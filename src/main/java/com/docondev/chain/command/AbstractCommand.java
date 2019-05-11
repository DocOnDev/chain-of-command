package com.docondev.chain.command;


public abstract class AbstractCommand {
    protected AbstractCommand nextCommand;

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
