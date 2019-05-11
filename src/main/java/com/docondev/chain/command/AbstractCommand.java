package com.docondev.chain.command;


import java.util.logging.Logger;

public abstract class AbstractCommand {
    private AbstractCommand nextCommand;
    static final Logger logger = Logger.getLogger(AbstractCommand.class.getName());


    public boolean execute(Controls controls) {
        if( isThisCommand(controls) ) {
            executeCommand();
            controls.setCommandRun(getCommandName());
            return true;
        }

        if(nextCommand != null) {
            return nextCommand.execute(controls);
        }
        return false;
    }

    protected abstract boolean isThisCommand(Controls controls);
    abstract void executeCommand();
    abstract String getCommandName();


    public void setNextCommand(AbstractCommand command) {
        this.nextCommand = command;
    }
}
