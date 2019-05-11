package com.docondev.chain.reporter;

import java.util.logging.Logger;

public abstract class AbstractDefaultReporter extends AbstractReporter {
    static final Logger logger = Logger.getLogger(AbstractDefaultReporter.class.getName());

    public AbstractDefaultReporter() { this.level = -1; }

    @Override
    protected boolean isThisReporter(Integer level) { return true; }

}
