package com.docondev.chain.reporter;

public abstract class AbstractReporter {
    protected Integer level;
    protected AbstractReporter nextReporter;

    public void setNextReporter(AbstractReporter nextReporter) {
        this.nextReporter = nextReporter;
    }

    public void setDefaultReporter(AbstractReporter defaultReporter) {
        if ( this.nextReporter != null )
            { this.nextReporter.setDefaultReporter(defaultReporter); }
        else
            { this.nextReporter = defaultReporter; }
        }


    public Integer reportMessage(Integer level, String message) {
        if( isThisReporter(level) ) {
            return write(message);
        }

        if(nextReporter != null) {
            return nextReporter.reportMessage(level, message);
        }

        return 0;
    }

    abstract protected boolean isThisReporter(Integer level);
    abstract protected Integer write(String message);

}
