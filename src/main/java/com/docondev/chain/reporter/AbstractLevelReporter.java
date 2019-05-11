package com.docondev.chain.reporter;

import java.util.logging.Logger;

public abstract class AbstractLevelReporter extends AbstractReporter {
    static final Logger logger = Logger.getLogger(AbstractLevelReporter.class.getName());

    @Override
    protected boolean isThisReporter(Integer level) {
        return this.level.equals(level);
    }

}
