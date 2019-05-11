package com.docondev.chain.reporter;

public class DefaultReporter extends AbstractDefaultReporter {
    @Override
    protected Integer write(String message) {
        logger.info("Default Reporter: " + message);
        return level;
    }
}
