package com.javalings.cli;
import java.nio.file.Files;
import java.nio.file.Path;

import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ProgressManager;
import com.javalings.models.ExerciseInfo;
import com.javalings.models.Progress;

import picocli.CommandLine;

@CommandLine.Command(
    name = "show",
    description = "Show current exercise"
)
public class ShowCommand implements Runnable{

    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();
        Progress progress = manager.load();

        ExerciseRegistry registry = new ExerciseRegistry();
        ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

        if (info == null) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,red No exercise found for the current progress! |@"));
            return;
        }

        System.out.println();
        System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,cyan 📖 " + info.getTopic().getTitle().toUpperCase() + " - " + info.getExerciseName() + " |@"));
        System.out.println();

        try {
            String readme = Files.readString(Path.of(info.getReadmePath()));
            System.out.println(readme);
        } catch (Exception e) {
            System.out.println("No README found for this exercise.");
        }
    }
}
