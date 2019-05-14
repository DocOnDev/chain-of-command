package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations.SUSPICIOUS;
import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations.TRUSTWORTHY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WerewolfEvaluatorCommandTest {

    private Suspect suspect;
    private WerewolfEvaluatorCommand werewolfEvaluator;

    @Before
    public void setUp() {
        suspect = new Suspect();
        werewolfEvaluator = new WerewolfEvaluatorCommand();
    }

    @Test
    public void confirmWerewolfEvaluator_ReportsWarewolfEvaluator() {
        assertThat(werewolfEvaluator.execute(suspect).getCommandName(), is(equalTo("Werewolf Evaluator")));
    }


    @Test
    public void givenSuspectHasFurAndIsLycanthrope_Suspicious() {
        suspect.addProperty("fur");
        suspect.addHobby("lycanthropy");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFurAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("fur");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectHasFangsAndIsLycanthrope_Suspicious() {
        suspect.addProperty("fangs");
        suspect.addHobby("lycanthropy");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFangsAndHowlsAtMoon_Suspicious() {
        suspect.addProperty("fangs");
        suspect.addHobby("howling at the moon");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFangsAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("fangs");
        suspect.addHobby("rock climbing");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectHasClawssAndIsLycanthrope_Suspicious() {
        suspect.addProperty("claws");
        suspect.addHobby("lycanthropy");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasClawsAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("claws");
        assertThat(werewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

}