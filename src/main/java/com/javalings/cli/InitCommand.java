package com.javalings.cli;

import picocli.CommandLine.Command;
import java.io.File;

@Command(name = "init", description = "Initialize the javalings project in the current directory")
public class InitCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Initializing Javalings...");
        File dir = new File("javalings");
        if (dir.exists()) {
            System.out.println("Directory 'javalings' already exists!");
            return;
        }

        try {
            System.out.println("Cloning the Javalings repository...");
            ProcessBuilder pb = new ProcessBuilder("git", "clone", "https://github.com/SATYAM-PRATIBHAN/javalings.git");
            pb.inheritIO();
            Process process = pb.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                System.out.println("\n✅ Successfully initialized Javalings!");
                System.out.println("👉 Run 'cd javalings' and then 'javalings' to get started.");
            } else {
                System.out.println("\n❌ Failed to initialize javalings. Do you have git installed?");
            }
        } catch (Exception e) {
            System.out.println("An error occurred during initialization.");
            e.printStackTrace();
        }
    }
}
