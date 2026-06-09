package com.javalings.cli;

import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ProgressManager;
import com.javalings.models.ExerciseInfo;
import com.javalings.models.Progress;
import picocli.CommandLine;

@CommandLine.Command(
    name = "hint",
    description = "Get a hint for the current exercise"
)
public class HintCommand implements Runnable {
    @Override
    public void run() {
        ProgressManager manager = new ProgressManager();
        Progress progress = manager.load();

        ExerciseRegistry registry = new ExerciseRegistry();
        ExerciseInfo info = registry.getExercise(progress.getCurrentExercise());

        if (info == null) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string(" @|bold,green 🎉 You have completed all Javalings exercises! |@"));
            return;
        }

        System.out.println(CommandLine.Help.Ansi.AUTO.string("\n@|bold,yellow 💡 Hint for " + info.getExerciseName() + ":|@"));

        if (info.getTopic().getHints() != null && info.getTopic().getHints().containsKey(info.getExerciseName())) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("  " + info.getTopic().getHints().get(info.getExerciseName()) + "\n"));
        } else {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("  @|italic No hint available for this exercise. You can do it!|@\n"));
        }
    }
}
