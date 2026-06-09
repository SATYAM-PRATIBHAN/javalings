package com.javalings.cli;

import picocli.CommandLine;

@CommandLine.Command(
    name = "next",
    description = "Move to next exercise"
)
public class NextCommand implements Runnable{
    @Override
    public void run() {
        com.javalings.engine.ProgressManager manager = new com.javalings.engine.ProgressManager();
        com.javalings.models.Progress progress = manager.load();
        
        com.javalings.engine.ExerciseRegistry registry = new com.javalings.engine.ExerciseRegistry();
        com.javalings.models.ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

        if (info == null) {
            System.out.println(picocli.CommandLine.Help.Ansi.AUTO.string(" @|bold,green 🎉 You have completed all Javalings exercises! |@"));
            return;
        }

        com.javalings.engine.ExerciseRunner runner = new com.javalings.engine.ExerciseRunner();
        boolean success = runner.runCurrentExercise(info);

        if (!success) {
            System.out.println(picocli.CommandLine.Help.Ansi.AUTO.string("\n@|bold,red ❌ Cannot advance. Please fix the exercise first!|@"));
            return;
        }

        try {
            String content = java.nio.file.Files.readString(java.nio.file.Path.of(info.getExercisePath()));
            if (content.contains("// I AM NOT DONE")) {
                System.out.println(picocli.CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow ⚠️  Tests passed! Remove `// I AM NOT DONE` from the file to advance.|@"));
                return;
            }
        } catch (Exception e) {
            System.out.println("Could not read exercise file.");
            return;
        }

        progress.setCurrentExercise(progress.getCurrentExercise() + 1);
        manager.save(progress);

        System.out.println(
            picocli.CommandLine.Help.Ansi.AUTO.string(
                "\n@|bold,green ✓|@ Moved to next exercise!"
            )
        );
    }
}
