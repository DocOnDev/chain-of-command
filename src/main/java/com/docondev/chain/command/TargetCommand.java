package com.docondev.chain.command;

public class TargetCommand extends AbstractCommand {

    private static final String COMMAND_NAME = "Target";

    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentTargets();
    }

    @Override
    void executeCommand() {
        logger.info(COMMAND_NAME + " Command");
    }

    @Override
    String getCommandName() {
        return COMMAND_NAME;
    }
}
