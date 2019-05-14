package com.docondev.chain.suspect;

class Detective {

    private Detective() {
        throw new IllegalStateException("Static class");
    }

    static EvaluatorResponse shouldDetainSuspect(Suspect suspect) {
        WitchEvaluatorCommand witchEvaluator = new WitchEvaluatorCommand();
        VampireEvaluatorCommand vampireEvaluator = new VampireEvaluatorCommand();

        vampireEvaluator.setNextCommand(new WerewolfEvaluatorCommand());
        witchEvaluator.setNextCommand(vampireEvaluator);

        return witchEvaluator.execute(suspect);
    }
}
