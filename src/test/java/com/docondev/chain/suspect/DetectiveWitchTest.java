package com.docondev.chain.suspect;

import com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetectiveWitchTest {

    private Suspect suspect = new Suspect();

    @Before
    public void setUp() {
        suspect.setWeight(InterestingFacts.DUCK_WEIGHT);
        suspect.setVolume(4.0);
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndNotWooden_Innocent() {
        suspect.addProperty("stone");
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndWooden_Suspiscous() {
        suspect.addProperty("wood");
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.SUSPICIOUS)));
    }

    @Test
    public void givenSuspectIsFloatableAndNotDuckWeightAndWooden_Innocent() {
        suspect.addProperty("wood");
        suspect.setWeight(InterestingFacts.DUCK_WEIGHT + 0.1);
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsNotFloatableAndDuckWeightAndWooden_Innocent() {
        suspect.addProperty("wood");
        suspect.setVolume(0.4);
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }
}
