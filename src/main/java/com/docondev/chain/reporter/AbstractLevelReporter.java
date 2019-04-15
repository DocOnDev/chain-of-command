package com.docondev.chain.reporter;

public abstract class AbstractLevelReporter extends AbstractReporter {

    @Override
    protected boolean isThisReporter(Integer level) {
        return this.level.equals(level);
    }

}
