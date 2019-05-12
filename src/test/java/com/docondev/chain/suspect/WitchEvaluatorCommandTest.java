package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WitchEvaluatorCommandTest {
    private Suspect suspect = new Suspect();
    private WitchEvaluatorCommand witchEvaluator = new WitchEvaluatorCommand();

    @Before
    public void setUp() {
        suspect.setWeight(InterestingFacts.DUCK_WEIGHT);
        suspect.setVolume(4.0);
    }

    @Test
    public void confirmWitchEvaluator_ReportsWitchEvaluator() {
        assertThat(witchEvaluator.execute(suspect).getCommandName(), is(equalTo("Witch Evaluator")));
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndNotWooden_Trustworthy() {
        assertThat(witchEvaluator.execute(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndWooden_Suspicious() {
        suspect.addProperty("wood");
        assertThat(witchEvaluator.execute(suspect).getEvaluation(), is(equalTo(Evaluations.SUSPICIOUS)));
    }

    @Test
    public void givenSuspectIsFloatableAndNotDuckWeightAndWooden_Trustworthy() {
        suspect.addProperty("wood");
        suspect.setWeight(InterestingFacts.DUCK_WEIGHT + 0.01);
        assertThat(witchEvaluator.execute(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsNotFloatableAndDuckWeightAndWooden_Trustworthy() {
        suspect.addProperty("wood");
        suspect.setVolume(0.4);
        assertThat(witchEvaluator.execute(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

}