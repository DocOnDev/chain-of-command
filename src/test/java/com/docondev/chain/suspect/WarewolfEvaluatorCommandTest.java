package com.docondev.chain.suspect;

import org.junit.Before;
import org.junit.Test;

import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations.SUSPICIOUS;
import static com.docondev.chain.suspect.AbstractEvaluatorCommand.Evaluations.TRUSTWORTHY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WarewolfEvaluatorCommandTest {

    private Suspect suspect;
    private WarewolfEvaluatorCommand warewolfEvaluator;

    @Before
    public void setUp() {
        suspect = new Suspect();
        warewolfEvaluator = new WarewolfEvaluatorCommand();
    }

    @Test
    public void confirmWarewolfEvaluator_ReportsWarewolfEvaluator() {
        assertThat(warewolfEvaluator.execute(suspect).getCommandName(), is(equalTo("Warewolf Evaluator")));
    }


    @Test
    public void givenSuspectHasFurAndIsLycanthrope_Suspiscous() {
        suspect.addProperty("fur");
        suspect.addHobby("lycanthropy");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFurAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("fur");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectHasFangsAndIsLycanthrope_Suspiscous() {
        suspect.addProperty("fangs");
        suspect.addHobby("lycanthropy");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFangsAndHowlsAtMoon_Suspiscous() {
        suspect.addProperty("fangs");
        suspect.addHobby("howling at the moon");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasFangsAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("fangs");
        suspect.addHobby("rock climbing");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

    @Test
    public void givenSuspectHasClawssAndIsLycanthrope_Suspiscous() {
        suspect.addProperty("claws");
        suspect.addHobby("lycanthropy");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(SUSPICIOUS)));
    }

    @Test
    public void givenSuspectHasClawsAndIsNotLycanthrope_Innocent() {
        suspect.addProperty("claws");
        assertThat(warewolfEvaluator.execute(suspect).getEvaluation(), is(equalTo(TRUSTWORTHY)));
    }

}