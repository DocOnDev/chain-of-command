package com.docondev.chain.command;

public class MixRateCommand extends AbstractCommand {

    private static final String COMMAND_NAME = "Mix Rate";

    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentMixRates();

    }

    @Override
    void executeCommand() {
        logger.info(String.format("%s Command", COMMAND_NAME));
    }

    @Override
    String getCommandName() {
        return COMMAND_NAME;
    }
}
