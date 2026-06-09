package com.javalings;
import com.javalings.cli.ListCommand;
import com.javalings.cli.NextCommand;
import com.javalings.cli.RunCommand;
import com.javalings.cli.ShowCommand;

import picocli.CommandLine;

@CommandLine.Command(
    name = "javalings",
    mixinStandardHelpOptions = true,
    version = "0.1.0",
    description = "Learn Java by fixing broken code.",
    subcommands = {
        ListCommand.class,
        ShowCommand.class,
        NextCommand.class,
        RunCommand.class
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
            
            Try running one of these commands:
              @|yellow ⚡ javalings list|@   - Show all available exercises
              @|yellow ⚡ javalings run|@    - Compile and test the current exercise
              @|yellow ⚡ javalings watch|@  - Keep an eye out for your file changes
            """));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}