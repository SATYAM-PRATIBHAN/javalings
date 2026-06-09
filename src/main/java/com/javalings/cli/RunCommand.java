package com.javalings.cli;

import com.javalings.engine.ExerciseRunner;

import picocli.CommandLine;

@CommandLine.Command(
    name = "run",
    description = "Run current exercise"
)
public class RunCommand implements Runnable{
    @Override
    public void run() {
        com.javalings.engine.ProgressManager manager = new com.javalings.engine.ProgressManager();
        com.javalings.models.Progress progress = manager.load();

        com.javalings.engine.ExerciseRegistry registry = new com.javalings.engine.ExerciseRegistry();
        com.javalings.models.ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

        if (info == null) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,red Could not find exercise for ID: " + progress.getCurrentExercise() + " |@"));
            return;
        }

        ExerciseRunner runner = new ExerciseRunner();
        boolean success = runner.runCurrentExercise(info);

        if(success) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,green 🎉 Exercise Passed!|@"));
        } else {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,red ❌ Exercise Failed.|@"));
        }
    }
}
