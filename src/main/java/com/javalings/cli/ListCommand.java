package com.javalings.cli;

import picocli.CommandLine;

@CommandLine.Command(
    name = "list",
    description = "List exercises"
)
public class ListCommand implements Runnable{
    
    @Override
    public void run() {
        System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,cyan Available Exercises:|@\n"));
        
        com.javalings.engine.ProgressManager manager = new com.javalings.engine.ProgressManager();
        com.javalings.models.Progress progress = manager.load();
        int currentId = progress.getCurrentExercise();

        com.javalings.engine.ExerciseRegistry registry = new com.javalings.engine.ExerciseRegistry();
        for (com.javalings.models.ExerciseInfo info : registry.getAllExercises()) {
            String checkbox = info.getGlobalId() < currentId ? "@|green [x]|@" : 
                              (info.getGlobalId() == currentId ? "@|yellow [/]|@" : "[ ]");
            
            System.out.println(CommandLine.Help.Ansi.AUTO.string(
                checkbox + " @|bold " + info.getTopic().getTitle() + " - " + info.getExerciseName() + "|@"
            ));
        }
    }
}
