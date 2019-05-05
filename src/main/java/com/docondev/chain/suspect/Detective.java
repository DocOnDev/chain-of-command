package com.docondev.chain.suspect;

import java.util.function.Predicate;

public class Detective {

    private static final Double DUCK_WEIGHT = 4.2;
    private static final double WATER_DENSITY = 8.333;  // lb/gal or 62.335 lb/ft3
    private static final boolean SUSPICIOUS = true;
    private static final boolean TRUSTWORTHY = false;

    public boolean shouldDetainSuspect(Suspect suspect) {
        boolean isMadeOfWood = suspect.getProperties().stream()
                .anyMatch(p -> p.contains("wood"));

        boolean isDuckWeight = suspect.getWeight()
                .equals(DUCK_WEIGHT);

        Double weight = suspect.getWeight();
        Double volume = suspect.getVolume();

        boolean isFloatable = (weight / volume) < WATER_DENSITY;

        boolean isLycanthrope = suspect.getHobbies().stream().anyMatch(p -> p.contains("lycanthropy"));

        Predicate<String> caninePredicate = p -> p.contains("claws") || p.contains("fur") || p.contains("fangs");
        boolean isCanineLike = suspect.getProperties().stream().anyMatch(caninePredicate);

        if (isFloatable && isMadeOfWood && isDuckWeight) {
            return SUSPICIOUS;
        }
        if (isLycanthrope && isCanineLike) {
            return SUSPICIOUS;
        }
        if (suspect.getDoctor().getLastName().equals("VanHelsing") &&
                suspect.getHomeTown().equals("Wallachian") &&
                suspect.getOccupation().equals("prince")) {
            return SUSPICIOUS;
        }
        return TRUSTWORTHY;
    }
}
