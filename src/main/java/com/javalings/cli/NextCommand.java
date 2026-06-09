package com.javalings.cli;

import com.javalings.engine.ProgressManager;
import com.javalings.models.Progress;

import picocli.CommandLine;

@CommandLine.Command(
    name = "next",
    description = "Move to next exercise"
)
public class NextCommand implements Runnable{
    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();

        Progress progress = manager.load();

        progress.setCurrentExercise(
            progress.getCurrentExercise() + 1
        );

        manager.save(progress);

        System.out.println(
            CommandLine.Help.Ansi.AUTO.string(
                "@|bold,green ✓|@ Moved to exercise @|bold,cyan "
                + progress.getCurrentExercise() + "|@"
            )
        );
    }
}
