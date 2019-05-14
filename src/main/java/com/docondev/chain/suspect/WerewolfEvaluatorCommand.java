package com.docondev.chain.suspect;

public class WerewolfEvaluatorCommand extends AbstractEvaluatorCommand {
    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return isCanineLike(suspect) && isLycanthrope(suspect);
    }

    private static boolean isCanineLike(Suspect suspect) {
        return suspect.getProperties().stream().anyMatch(InterestingFacts.canineAttributes::contains);
    }

    private static boolean isLycanthrope(Suspect suspect) {
        return suspect.getHobbies().stream().anyMatch(InterestingFacts.warewolfHobbies::contains);
    }

}
