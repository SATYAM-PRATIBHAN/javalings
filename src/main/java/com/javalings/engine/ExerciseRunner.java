package com.javalings.engine;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import picocli.CommandLine;

public class ExerciseRunner {
    public boolean runCurrentExercise(com.javalings.models.ExerciseInfo info) {
        System.out.println(CommandLine.Help.Ansi.AUTO.string("Compiling exercise @|bold,cyan " + info.getExerciseName() + "|@..."));

        try {
            // 1. Setup temp output directory
            Path tempDir = Files.createTempDirectory("javalings_out");
            tempDir.toFile().deleteOnExit();

            // 2. Find all Java files
            File javaFile = new File(info.getExercisePath());
            File testFile = new File(info.getTestPath());
            if (!javaFile.exists() || !testFile.exists()) {
                System.out.println("Java file or Test file not found for this exercise.");
                return false;
            }

            // 3. Compile
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            if (compiler == null) {
                System.out.println("JDK is required to run Javalings. You are currently using a JRE.");
                return false;
            }

            List<String> options = new ArrayList<>();
            options.add("-d");
            options.add(tempDir.toString());
            
            // Add classpath to compiler so it can find JUnit annotations
            StringBuilder cp = new StringBuilder(System.getProperty("java.class.path"));
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl instanceof URLClassLoader) {
                for (URL url : ((URLClassLoader) cl).getURLs()) {
                    cp.append(File.pathSeparator).append(new File(url.toURI()).getAbsolutePath());
                }
            } else {
                // Fallback for non-URLClassLoaders, dynamically resolve known JUnit jars
                try {
                    cp.append(File.pathSeparator).append(new File(Test.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath());
                    cp.append(File.pathSeparator).append(new File(Assertions.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath());
                } catch (Exception e) {}
            }
            options.add("-cp");
            options.add(cp.toString());

            options.add(javaFile.getAbsolutePath());
            options.add(testFile.getAbsolutePath());

            int compilationResult = compiler.run(null, null, null, options.toArray(new String[0]));
            if (compilationResult != 0) {
                System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,red Compilation failed!|@ Check the errors above."));
                return false;
            }

            // 4. Load classes and Run tests
            URLClassLoader classLoader = URLClassLoader.newInstance(
                new URL[]{tempDir.toUri().toURL()}, 
                Thread.currentThread().getContextClassLoader()
            );
            
            Class<?> testClass;
            try {
                testClass = Class.forName(info.getExerciseName() + "Test", true, classLoader);
            } catch (ClassNotFoundException e) {
                System.out.println("Could not find " + info.getExerciseName() + "Test class.");
                return false;
            }

            // Run JUnit test
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(DiscoverySelectors.selectClass(testClass))
                    .build();

            Launcher launcher = LauncherFactory.create();
            SummaryGeneratingListener listener = new SummaryGeneratingListener();
            launcher.registerTestExecutionListeners(listener);
            
            // Execute the tests
            Thread currentThread = Thread.currentThread();
            ClassLoader originalClassLoader = currentThread.getContextClassLoader();
            try {
                currentThread.setContextClassLoader(classLoader);
                launcher.execute(request);
            } finally {
                currentThread.setContextClassLoader(originalClassLoader);
            }

            TestExecutionSummary summary = listener.getSummary();

            if (summary.getTestsFailedCount() > 0) {
                System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,red Testing failed:|@"));
                summary.getFailures().forEach(failure -> {
                    System.out.println("  - " + failure.getTestIdentifier().getDisplayName() + " : " + failure.getException().getMessage());
                });
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
