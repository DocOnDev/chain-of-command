package com.docondev.chain.command;

public class MixRateCommand extends AbstractCommand {

    private static final String commandName = "Mix Rate";

    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentMixRates();

    }

    @Override
    void executeCommand() {
        System.out.println(commandName + " Command");
    }

    @Override
    String getCommandName() {
        return commandName;
    }
}
