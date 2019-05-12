package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class VampireEvaluatorCommandTest {

    private VampireEvaluatorCommand vampireEvaluator;
    private Suspect suspect;

    @Before
    public void setUp() {
        vampireEvaluator = new VampireEvaluatorCommand();
        suspect = new Suspect();
    }

    @Test
    public void confirmVampireEvaluator_ReportsVampireEvaluator() {
        assertThat(vampireEvaluator.execute(suspect).getCommandName(), is(equalTo("Vampire Evaluator")));
    }

    @Test
    public void givenPrinceAndNotFromWallachian_Trustworthy() {
        assertThat(vampireEvaluator.execute(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }
}