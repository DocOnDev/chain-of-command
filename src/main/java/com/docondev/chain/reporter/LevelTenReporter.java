package com.docondev.chain.reporter;

public class LevelTenReporter extends AbstractLevelReporter{
    public LevelTenReporter() {
        this.level = 10;
    }

    @Override
    protected Integer write(String message) {
        System.out.println("Level 10 Reporter: " + message);
        return level;
    }

}
