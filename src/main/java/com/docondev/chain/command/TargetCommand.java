package com.docondev.chain.command;

public class TargetCommand extends AbstractCommand {

    private static final String commandName = "Target";

    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentTargets();
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
