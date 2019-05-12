package com.docondev.chain.suspect;

public class WitchEvaluatorCommand extends AbstractEvaluatorCommand {
    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return isFloatable(suspect) && isWooden(suspect) && isDuckWeight(suspect);
    }

    private static Boolean isWooden(Suspect suspect) {
        return suspect.getProperties().stream()
                .anyMatch(p -> p.contains("wood"));
    }

    private static Boolean isDuckWeight(Suspect suspect) {
        return suspect.getWeight()
                .equals(InterestingFacts.DUCK_WEIGHT);
    }

    private static Boolean isFloatable(Suspect suspect) {
        double suspectDensity = suspect.getWeight() / suspect.getVolume();
        return suspectDensity < InterestingFacts.WATER_DENSITY;
    }

}
