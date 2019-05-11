package com.docondev.chain.reporter;

public class LevelOneHundredReporter extends AbstractLevelReporter {
    public LevelOneHundredReporter() {
        this.level = 100;
    }

    @Override
    protected Integer write(String message) {
        logger.info("Level 100 Reporter: " + message);
        return this.level;
    }
}
