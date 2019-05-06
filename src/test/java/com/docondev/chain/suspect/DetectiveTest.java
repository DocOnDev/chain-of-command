package com.docondev.chain.suspect;

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
    public void givenWeightDividedByVolumeLessThanWaterDensity_Floatable() {
        assertThat(Detective.isFloatable(suspect), is(true));
    }

    @Test
    public void givenWeightIsMoreThanDuck_NotDuckWeight() {
        assertThat(Detective.isDuckWeight(suspect), is(false));
    }

    @Test
    public void givenWeightIsLessThanDuck_NotDuckWeight() {
        suspect.setWeight(Detective.DUCK_WEIGHT - 1);
        assertThat(Detective.isDuckWeight(suspect), is(false));
    }

    @Test
    public void givenWeightSameAsDuck_DuckWeight() {
        suspect.setWeight(Detective.DUCK_WEIGHT);
        assertThat(Detective.isDuckWeight(suspect), is(true));
    }

    @Test
    public void givenSuspectIsFloatableAndNotDuckWeight_Innocent() {
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenWoodProperty_IsMadeofWood() {
        suspect.addProperty("wood");
        assertThat(Detective.isMadeOfWood(suspect), is(true));
    }


}
