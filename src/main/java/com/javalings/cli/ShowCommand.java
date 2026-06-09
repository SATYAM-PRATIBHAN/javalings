package com.javalings.cli;
import java.nio.file.Files;
import java.nio.file.Path;

import com.javalings.engine.TopicLoader;
import com.javalings.models.Topic;

import picocli.CommandLine;

@CommandLine.Command(
    name = "show",
    description = "Show current exercise"
)
public class ShowCommand implements Runnable{

    @Override
    public void run() {
        com.javalings.engine.ProgressManager manager = new com.javalings.engine.ProgressManager();
        com.javalings.models.Progress progress = manager.load();

        com.javalings.engine.ExerciseRegistry registry = new com.javalings.engine.ExerciseRegistry();
        com.javalings.models.ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

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
