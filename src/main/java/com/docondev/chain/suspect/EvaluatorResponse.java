package com.docondev.chain.suspect;


import com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;

public class EvaluatorResponse {
    private final String commandName;
    private final Evaluations evaluation;

    EvaluatorResponse(String commandName, Evaluations evaluation) {
        this.commandName = commandName;
        this.evaluation = evaluation;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public Evaluations getEvaluation() {
        return this.evaluation;
    }
}