package com.docondev.chain.reporter;

public class DefaultReporter extends AbstractDefaultReporter {
    @Override
    protected Integer write(String message) {
        logger.info(String.format("Default Reporter: %s", message));
        return level;
    }
}
