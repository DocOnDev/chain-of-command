package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetectiveWarewolfTest {

    private Suspect suspect = new Suspect();

    @Before
    public void setUp() {
        suspect.setWeight(Detective.DUCK_WEIGHT);
        suspect.setVolume(4.0);
    }

    @Test
    public void givenSuspectIsLycanthropeAndNotCanineLike_Innocent() {
        suspect.addHobby("lycanthropy");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSUspectHasNoClawsOrFangsOrFur_IsNotCanineLike() {
        assertThat(Detective.isCanineLike(suspect), is(false));
    }

    @Test
    public void givenSuspectHasClaws_IsCanineLike() {
        suspect.addProperty("claws");
        assertThat(Detective.isCanineLike(suspect), is(true));
    }

    @Test
    public void givenSuspectHasFur_IsCanineLike() {
        suspect.addProperty("fur");
        assertThat(Detective.isCanineLike(suspect), is(true));
    }

    @Test
    public void givenSuspectHasFangs_IsCanineLike() {
        suspect.addProperty("fangs");
        assertThat(Detective.isCanineLike(suspect), is(true));
    }

    @Test
    public void givenSUspectHasClawsAndFangsAndFur_IsCanineLike() {
        suspect.addProperty("claws");
        suspect.addProperty("fur");
        suspect.addProperty("fangs");
        assertThat(Detective.isCanineLike(suspect), is(true));
    }
}
