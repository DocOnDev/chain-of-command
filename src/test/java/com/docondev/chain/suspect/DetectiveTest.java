package com.docondev.chain.suspect;

import com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class DetectiveTest {

    private static final double TEST_WEIGHT = 200.0;
    private static final double TEST_VOLUME = 28.2;
    private Suspect suspect = new Suspect();

    @Before
    public void setUp() {
        suspect.setWeight(TEST_WEIGHT);
        suspect.setVolume(TEST_VOLUME);
    }

    @Test
    public void givenSuspectIsFloatableAndNotDuckWeight_Innocent() {
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

}
