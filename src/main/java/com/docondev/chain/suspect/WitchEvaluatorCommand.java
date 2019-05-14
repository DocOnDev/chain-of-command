package com.docondev.chain.suspect;

public class WitchEvaluatorCommand extends AbstractEvaluatorCommand {
    static final Double DUCK_WEIGHT = 4.2;
    private static final double WATER_DENSITY = 8.333;  // lb/gal or 62.335 lb/ft3

    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return isFloatable(suspect) && isWooden(suspect) && isDuckWeight(suspect);
    }

    private Boolean isWooden(Suspect suspect) {
        return suspect.hasProperty("wood");
    }

    private static Boolean isDuckWeight(Suspect suspect) {
        return suspect.getWeight()
                .equals(DUCK_WEIGHT);
    }

    private static Boolean isFloatable(Suspect suspect) {
        double suspectDensity = suspect.getWeight() / suspect.getVolume();
        return suspectDensity < WATER_DENSITY;
    }

}
