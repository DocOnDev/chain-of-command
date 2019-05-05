package com.docondev.chain.suspect;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;


public class SuspectTest {

    @Test
    public void confirmSuspectHasDefaultWeightGreaterThanZero() {
        Suspect suspect = new Suspect();
        assertThat(suspect.getWeight(), is(greaterThan(0.0)));
    }

    @Test
    public void confirmSuspectHasDefaultVolumeGreaterThanZero() {
        Suspect suspect = new Suspect();
        assertThat(suspect.getVolume(), is(greaterThan(0.0)));
    }
}
