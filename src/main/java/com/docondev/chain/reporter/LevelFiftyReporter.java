package com.docondev.chain.reporter;

public class LevelFiftyReporter extends AbstractLevelReporter {
    public LevelFiftyReporter() {
        this.level = 50;
    }

    @Override
    protected Integer write(String message) {
        System.out.println("Level 50 Reporter: " + message);
        return this.level;
    }
}
