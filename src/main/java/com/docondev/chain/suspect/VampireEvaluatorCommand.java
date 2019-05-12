package com.docondev.chain.suspect;

public class VampireEvaluatorCommand extends AbstractEvaluatorCommand {
    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return false;
    }
}
