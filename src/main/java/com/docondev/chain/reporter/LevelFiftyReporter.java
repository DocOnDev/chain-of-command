package com.docondev.chain.reporter;

public class LevelFiftyReporter extends AbstractLevelReporter {
    public LevelFiftyReporter() {
        this.level = 50;
    }

    @Override
    protected Integer write(String message) {
        logger.info(String.format("Level 50 Reporter: %s", message));
        return this.level;
    }
}
