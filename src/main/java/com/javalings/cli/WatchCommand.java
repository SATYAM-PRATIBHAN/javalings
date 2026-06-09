package com.javalings.cli;

import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ExerciseRunner;
import com.javalings.engine.ProgressManager;
import com.javalings.models.ExerciseInfo;
import com.javalings.models.Progress;
import picocli.CommandLine;
import java.nio.file.*;

@CommandLine.Command(
    name = "watch",
    description = "Keep an eye out for your file changes"
)
public class WatchCommand implements Runnable {

    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();
        ExerciseRegistry registry = new ExerciseRegistry();
        ExerciseRunner runner = new ExerciseRunner();

        java.util.concurrent.atomic.AtomicBoolean forceCheck = new java.util.concurrent.atomic.AtomicBoolean(false);

        Thread inputThread = new Thread(() -> {
            @SuppressWarnings("resource")
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hint")) {
                    Progress progress = manager.load();
                    ExerciseInfo currentInfo = registry.getExercise(progress.getCurrentExercise());
                    if (currentInfo != null && currentInfo.getTopic().getHints() != null && currentInfo.getTopic().getHints().containsKey(currentInfo.getExerciseName())) {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow 💡 Hint for " + currentInfo.getExerciseName() + ":|@"));
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("  " + currentInfo.getTopic().getHints().get(currentInfo.getExerciseName())));
                    } else {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n  @|italic No hint available for this exercise. You can do it!|@"));
                    }
                    printFooter(currentInfo, manager, registry);
                } else if (input.equalsIgnoreCase("l") || input.equalsIgnoreCase("list")) {
                    System.out.println();
                    new com.javalings.cli.ListCommand().run();
                    Progress progress = manager.load();
                    ExerciseInfo currentInfo = registry.getExercise(progress.getCurrentExercise());
                    printFooter(currentInfo, manager, registry);
                } else if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                    System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,cyan 👋 Exiting Javalings watch mode. Bye!|@"));
                    System.exit(0);
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            
            while (true) {
                Progress progress = manager.load();
                ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

                clearScreen();

                if (info == null) {
                    System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,green 🎉 You have completed all Javalings exercises! |@"));
                    return;
                }

                System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,cyan 👀 Watching " + info.getExerciseName() + "... |@\n"));

                boolean success = runner.runCurrentExercise(info);

                if (success) {
                    String content = Files.readString(Path.of(info.getExercisePath()));
                    if (content.contains("// I AM NOT DONE")) {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow ⚠️  Tests passed! Remove `// I AM NOT DONE` from the file to advance.|@"));
                    } else {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,green 🎉 Exercise Passed! Auto-advancing to next exercise...|@"));
                        progress.setCurrentExercise(progress.getCurrentExercise() + 1);
                        manager.save(progress);
                        Thread.sleep(1500); 
                        continue; 
                    }
                } else {
                    System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,red ❌ Exercise Failed. Fix the code and save to try again.|@"));
                }

                printFooter(info, manager, registry);

                Path dir = Path.of(info.getTopicPath());
                WatchKey key = dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                boolean changed = false;
                while (!changed && !forceCheck.get()) {
                    WatchKey activeKey = watchService.poll(500, java.util.concurrent.TimeUnit.MILLISECONDS);
                    if (activeKey != null) {
                        for (WatchEvent<?> event : activeKey.pollEvents()) {
                            Path changedFile = (Path) event.context();
                            if (changedFile.toString().equals(Path.of(info.getExercisePath()).getFileName().toString())) {
                                changed = true;
                            }
                        }
                        activeKey.reset();
                    }
                }
                
                if (forceCheck.get()) {
                    forceCheck.set(false);
                }

                key.cancel(); 
                Thread.sleep(100);
            }

        } catch (Exception e) {
            System.err.println("Watch service failed: " + e.getMessage());
        }
    }

    private void printFooter(ExerciseInfo info, ProgressManager manager, ExerciseRegistry registry) {
        Progress progress = manager.load();
        int currentId = progress.getCurrentExercise();
        int total = registry.getAllExercises().size();
        
        int completed = Math.min(currentId - 1, total);
        
        int barLength = 47;
        double percentage = total > 0 ? (double) completed / total : 0;
        int completedChars = (int) (percentage * barLength);
        
        StringBuilder bar = new StringBuilder();
        for(int i = 0; i < completedChars; i++) bar.append("@|green +|@");
        if(completedChars < barLength) bar.append(">");
        for(int i = completedChars + 1; i < barLength; i++) bar.append("@|red -|@");
        
        System.out.println(CommandLine.Help.Ansi.AUTO.string("\nProgress: [" + bar.toString() + "]  " + completed + "/" + total));
        if (info != null) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("Current exercise: @|blue,underline " + info.getExercisePath() + "|@\n"));
        } else {
            System.out.println("Current exercise: Completed!\n");
        }
        
        System.out.print(CommandLine.Help.Ansi.AUTO.string("@|bold h|@:hint / @|bold l|@:list / @|bold q|@:quit ? \n"));
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
