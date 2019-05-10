package com.docondev.chain.suspect;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetectiveVampireTest {

    private Suspect suspect = new Suspect();

    @Test
    public void givenSuspectDoctorIsVanHelsingAndNotAPrince_Innocent() {
        suspect.setDoctor("Abraham VanHelsing");
        suspect.setOccupation("jester");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsAPrinceAndDoctorIsNotVanHelsing_Innocent() {
        suspect.setDoctor("Leonard McCoy");
        suspect.setOccupation("prince");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsAPrinceAndDoctorIsVenHelsingAndHometownIsNotWallachian_Innocent() {
        suspect.setOccupation("Prince");
        suspect.setDoctor("Abraham VanHelsing");
        suspect.setHomeTown("New York");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsAPrinceAndDoctorIsVenHelsingAndHometownIsWallachian_Suspicious() {
        suspect.setOccupation("Prince");
        suspect.setDoctor("Abraham VanHelsing");
        suspect.setHomeTown("Wallachian");
        assertThat(Detective.shouldDetainSuspect(suspect), is(equalTo(Detective.SUSPICIOUS)));
    }
}
