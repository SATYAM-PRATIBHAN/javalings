package com.javalings.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ExerciseRunner;
import com.javalings.engine.ProgressManager;

import picocli.CommandLine;

@CommandLine.Command(
    name = "next",
    description = "Move to next exercise"
)
public class NextCommand implements Runnable{
    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();
        com.javalings.models.Progress progress = manager.load();
        
        ExerciseRegistry registry = new ExerciseRegistry();
        com.javalings.models.ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

        if (info == null) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,green 🎉 You have completed all Javalings exercises! |@"));
            return;
        }

        ExerciseRunner runner = new ExerciseRunner();
        boolean success = runner.runCurrentExercise(info);

        if (!success) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,red ❌ Cannot advance. Please fix the exercise first!|@"));
            return;
        }

        try {
            String content = Files.readString(Path.of(info.getExercisePath()));
            if (content.contains("// I AM NOT DONE")) {
                System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow ⚠️  Tests passed! Remove `// I AM NOT DONE` from the file to advance.|@"));
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
