package com.docondev.chain.reporter;

public abstract class AbstractDefaultReporter extends AbstractReporter {
    public AbstractDefaultReporter() { this.level = -1; }

    @Override
    protected boolean isThisReporter(Integer level) { return true; }

}
