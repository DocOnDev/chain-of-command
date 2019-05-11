package com.docondev.chain.reporter;

public class LevelOneHundredReporter extends AbstractLevelReporter {
    public LevelOneHundredReporter() {
        this.level = 100;
    }

    @Override
    protected Integer write(String message) {
        logger.info(String.format("Level 100 Reporter: %s", message));
        return this.level;
    }
}
