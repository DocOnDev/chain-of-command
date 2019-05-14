package com.docondev.chain.suspect;

import java.util.Arrays;
import java.util.List;

public class WerewolfEvaluatorCommand extends AbstractEvaluatorCommand {
    private static final List<String> canineAttributes = Arrays.asList("claws", "fur", "fangs");
    private static final List<String> werewolfHobbies = Arrays.asList("lycanthropy", "howling at the moon");

    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return isCanineLike(suspect) && isLycanthrope(suspect);
    }

    private static boolean isCanineLike(Suspect suspect) {
        return suspect.getProperties().stream().anyMatch(canineAttributes::contains);
    }

    private static boolean isLycanthrope(Suspect suspect) {
        return suspect.getHobbies().stream().anyMatch(werewolfHobbies::contains);
    }

}
