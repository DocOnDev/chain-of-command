package com.docondev.chain.suspect;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class VampireEvaluatorCommandTest {

    @Test
    public void confirmVampireEvaluator_ReportsVampireEvaluator() {
        Suspect suspect = new Suspect();
        VampireEvaluatorCommand vampireEvaluator = new VampireEvaluatorCommand();
        assertThat(vampireEvaluator.execute(suspect).getCommandName(), is(equalTo("Vampire Evaluator")));
    }


}