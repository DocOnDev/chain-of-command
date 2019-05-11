package com.docondev.chain.reporter;

public class LevelTenReporter extends AbstractLevelReporter{
    public LevelTenReporter() {
        this.level = 10;
    }

    @Override
    protected Integer write(String message) {
        logger.info(String.format("Level 10 Reporter: %s", message));
        return level;
    }

}
