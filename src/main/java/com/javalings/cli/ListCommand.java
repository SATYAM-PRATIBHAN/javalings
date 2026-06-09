package com.javalings.cli;

import picocli.CommandLine;

@CommandLine.Command(
    name = "list",
    description = "List exercises"
)
public class ListCommand implements Runnable{
    
    @Override
    public void run() {
        System.out.println(CommandLine.Help.Ansi.AUTO.string("""
                @|bold,cyan Available Exercises:|@
                
                @|green [ ]|@ @|bold 001 Variables|@
                """));
    }
}
