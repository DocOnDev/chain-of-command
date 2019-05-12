package com.docondev.chain.suspect;


public class EvaluatorResponse {
    private final String commandName;
    private final Boolean evaluation;

    EvaluatorResponse(String commandName, boolean evaluation) {
        this.commandName = commandName;
        this.evaluation = evaluation;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public Boolean getEvaluation() {
        return this.evaluation;
    }
}