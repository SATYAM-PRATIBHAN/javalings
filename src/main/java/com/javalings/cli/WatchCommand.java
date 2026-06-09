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

        Thread inputThread = new Thread(() -> {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hint")) {
                    Progress progress = manager.load();
                    ExerciseInfo currentInfo = registry.getExercise(progress.getCurrentExercise());
                    if (currentInfo != null && currentInfo.getTopic().getHints() != null && currentInfo.getTopic().getHints().containsKey(currentInfo.getExerciseName())) {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow 💡 Hint for " + currentInfo.getExerciseName() + ":|@"));
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("  " + currentInfo.getTopic().getHints().get(currentInfo.getExerciseName()) + "\n"));
                    } else {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n  @|italic No hint available for this exercise. You can do it!|@\n"));
                    }
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

                System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,cyan 👀 Watching " + info.getExerciseName() + "... |@"));
                System.out.println();

                boolean success = runner.runCurrentExercise(info);

                if (success) {
                    // Check for I AM NOT DONE
                    String content = Files.readString(Path.of(info.getExercisePath()));
                    if (content.contains("// I AM NOT DONE")) {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow ⚠️  Tests passed! Remove `// I AM NOT DONE` from the file to advance.|@"));
                    } else {
                        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,green 🎉 Exercise Passed! Auto-advancing to next exercise...|@"));
                        progress.setCurrentExercise(progress.getCurrentExercise() + 1);
                        manager.save(progress);
                        Thread.sleep(1500); // Give user a moment to read
                        continue; // Restart the loop with new exercise!
                    }
                } else {
                    System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,red ❌ Exercise Failed. Fix the code and save to try again.|@ @|yellow (Type 'h' for a hint!)|@"));
                }

                // Register watch key for current topic directory
                Path dir = Path.of(info.getTopicPath());
                WatchKey key = dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                // Wait for file change
                boolean changed = false;
                while (!changed) {
                    WatchKey activeKey = watchService.take();
                    for (WatchEvent<?> event : activeKey.pollEvents()) {
                        Path changedFile = (Path) event.context();
                        // Only trigger if the specific exercise file changed
                        if (changedFile.toString().equals(Path.of(info.getExercisePath()).getFileName().toString())) {
                            changed = true;
                        }
                    }
                    activeKey.reset();
                }

                key.cancel(); // Cancel old key before looping
                
                // Add a small delay to ensure file write is complete before recompiling
                Thread.sleep(100);
            }

        } catch (Exception e) {
            System.err.println("Watch service failed: " + e.getMessage());
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
