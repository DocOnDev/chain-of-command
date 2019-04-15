package com.docondev.chain.command;

public class MixRateCommand extends AbstractCommand {
    @Override
    protected boolean isThisCommand(Controls controls) {
        return controls.hasDifferentMixRates();

    }

    @Override
    void executeCommand() {

    }

    @Override
    String getCommandName() {
        return "Mix Rate";
    }
}
