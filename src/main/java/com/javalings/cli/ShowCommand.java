package com.javalings.cli;
import java.nio.file.Files;
import java.nio.file.Path;

import com.javalings.engine.ExerciseLoader;
import com.javalings.models.Exercise;

import picocli.CommandLine;

@CommandLine.Command(
    name = "show",
    description = "Show current exercise"
)
public class ShowCommand implements Runnable{

    @Override
    public void run() {
        ExerciseLoader loader = new ExerciseLoader();

        Exercise exercise = loader.load("exercises/001_variables");

        System.out.println();
        System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,cyan 📖 " + exercise.getTitle().toUpperCase() + " |@"));
        System.out.println();

        try {
            String readme = Files.readString(
                Path.of("exercises/001_variables/README.md")
            );

            System.out.println(readme);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
