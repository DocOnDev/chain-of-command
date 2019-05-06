package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetectiveWitchTest {

    private Suspect suspect = new Suspect();

    @Before
    public void setUp() {
        suspect.setWeight(Detective.DUCK_WEIGHT);
        suspect.setVolume(4.0);
    }

    @Test
    public void givenSuspectIsDuckWeightAndHighVolume_IsFloatable() {
        assertThat(Detective.isFloatable(suspect), is(true));
    }

    @Test
    public void givenSuspectIsDuckWeightAndLowVolume_IsNotFloatable() {
        suspect.setVolume(0.4);
        assertThat(Detective.isFloatable(suspect), is(false));
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndNotWooden_Innocent() {
        suspect.addProperty("stone");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsFloatableAndDuckWeightAndWooden_Suspiscous() {
        suspect.addProperty("wood");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.SUSPICIOUS)));
    }

    @Test
    public void givenSuspectIsFloatableAndNotDuckWeightAndWooden_Innocent() {
        suspect.addProperty("wood");
        suspect.setWeight(Detective.DUCK_WEIGHT + 0.1);
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsNotFloatableAndDuckWeightAndWooden_Innocent() {
        suspect.addProperty("wood");
        suspect.setVolume(0.4);
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));

    }
}
