package com.javalings.cli;

import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ExerciseRunner;
import com.javalings.engine.ProgressManager;
import com.javalings.models.ExerciseInfo;
import com.javalings.models.Progress;
import picocli.CommandLine;

@CommandLine.Command(
    name = "run",
    description = "Run current exercise"
)
public class RunCommand implements Runnable{
    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();
        Progress progress = manager.load();

        ExerciseRegistry registry = new ExerciseRegistry();
        ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

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
