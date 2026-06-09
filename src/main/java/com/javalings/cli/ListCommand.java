package com.javalings.cli;

import com.javalings.engine.ExerciseRegistry;
import com.javalings.engine.ProgressManager;
import com.javalings.models.ExerciseInfo;
import com.javalings.models.Progress;

import picocli.CommandLine;

@CommandLine.Command(
    name = "list",
    description = "List exercises"
)
public class ListCommand implements Runnable{
    
    @Override
    public void run() {
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,cyan Available Exercises:|@\n"));
        
        ProgressManager manager = new ProgressManager();
        Progress progress = manager.load();
        int currentId = progress.getCurrentExercise();

        ExerciseRegistry registry = new ExerciseRegistry();
        for (ExerciseInfo info : registry.getAllExercises()) {
            String checkbox = info.getGlobalId() < currentId ? "@|green [x]|@" : 
                              (info.getGlobalId() == currentId ? "@|yellow [/]|@" : "[ ]");
            
            System.out.println(CommandLine.Help.Ansi.AUTO.string(
                checkbox + " @|bold " + info.getTopic().getTitle() + " - " + info.getExerciseName() + "|@"
            ));
        }
    }
}
