package com.github.viniciusfcf.picocli;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine.Command;

@TopCommand
@Command( mixinStandardHelpOptions = true, subcommands = {HelloCommand.class, GoodByeCommand.class})
public class EntradaCommand {

    
}