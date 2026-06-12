package com.javalings;
import com.javalings.cli.HintCommand;
import com.javalings.cli.InitCommand;
import com.javalings.cli.ListCommand;
import com.javalings.cli.NextCommand;
import com.javalings.cli.RunCommand;
import com.javalings.cli.ShowCommand;
import com.javalings.cli.WatchCommand;

import picocli.CommandLine;

@CommandLine.Command(
    name = "javalings",
    mixinStandardHelpOptions = true,
    version = "0.1.0",
    description = "Learn Java by fixing broken code.",
    subcommands = {
        InitCommand.class,
        ListCommand.class,
        ShowCommand.class,
        NextCommand.class,
        RunCommand.class,
        WatchCommand.class,
        HintCommand.class
    }
)
public class Main implements Runnable{

    @Override
    public void run() {
        System.out.println(CommandLine.Help.Ansi.AUTO.string("""
@|bold,green                _                  _ _                 |@
@|bold,green               (_) __ ___   ____ _| (_)_ __   __ _ ___ |@
@|bold,green               | |/ _` \\ \\ / / _` | | | '_ \\ / _` / __||@
@|bold,green               | | (_| |\\ V / (_| | | | | | | (_| \\__ \\|@
@|bold,green              _/ |\\__,_| \\_/ \\__,_|_|_|_| |_|\\__, |___/|@
@|bold,green             |__/                            |___/     |@
            
            Welcome to @|bold,magenta Javalings|@! Learn Java by fixing broken code.
            """));

        java.io.File info = new java.io.File("info.json");
        if (!info.exists()) {
            System.out.println(CommandLine.Help.Ansi.AUTO.string("@|bold,red It looks like you are not in the Javalings project directory!|@"));
            System.out.println("Please run 'javalings init' to create the project.");
            return;
        }

        System.out.println(CommandLine.Help.Ansi.AUTO.string("""
            We will automatically start @|bold,yellow watch mode|@ in a moment!
            If you want to use manual commands, try:
              @|yellow ⚡ javalings list|@   - Show all available exercises
              @|yellow ⚡ javalings run|@    - Compile and test the current exercise
              @|yellow ⚡ javalings hint|@   - Get a hint if you are stuck
            """));
            
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Ignore
        }
        
        new WatchCommand().run();
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}