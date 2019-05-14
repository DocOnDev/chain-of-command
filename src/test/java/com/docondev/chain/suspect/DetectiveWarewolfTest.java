package com.docondev.chain.suspect;

import com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DetectiveWarewolfTest {

    private Suspect suspect = new Suspect();

    @Test
    public void givenSuspectIsLycanthropeAndNotCanineLike_Innocent() {
        suspect.addHobby("lycanthropy");
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }
    @Test
    public void givenSuspectIsCanineLikeAndNotLycanthrope_Innocent() {
        suspect.addProperty("fangs");
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectIsCanineLikeAndIsLycanthrope_Suspicious() {
        suspect.addProperty("fur");
        suspect.addHobby("lycanthropy");
        assertThat(Detective.shouldDetainSuspect(suspect).getEvaluation(), is(equalTo(Evaluations.SUSPICIOUS)));
    }
}
