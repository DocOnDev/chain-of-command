package com.docondev.chain.command;

public class TargetCommand extends AbstractCommand {

    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentTargets();
    }

    @Override
    void executeCommand() {

    }

    @Override
    String getCommandName() {
        return "Target";
    }
}
