package com.docondev.chain.suspect;

class Detective {

    static final boolean SUSPICIOUS = true;
    static final boolean TRUSTWORTHY = false;

    private Detective() {
        throw new IllegalStateException("Static class");
    }

    static boolean shouldDetainSuspect(Suspect suspect) {

        if (isFloatable(suspect) && isMadeOfWood(suspect) && isDuckWeight(suspect)) {
            return SUSPICIOUS;
        }
        if (isLycanthrope(suspect) && isCanineLike(suspect)) {
            return SUSPICIOUS;
        }
        if (suspect.getDoctor().getLastName().equalsIgnoreCase("VanHelsing") &&
                suspect.getHomeTown().equals("Wallachian") &&
                suspect.getOccupation().equalsIgnoreCase("Prince")) {
            return SUSPICIOUS;
        }
        return TRUSTWORTHY;
    }

    static boolean isCanineLike(Suspect suspect) {
        return suspect.getProperties().stream().anyMatch(InterestingFacts.canineAttributes::contains);
    }

    private static boolean isLycanthrope(Suspect suspect) {
        return suspect.getHobbies().stream().anyMatch(InterestingFacts.warewolfHobbies::contains);
    }

    static boolean isFloatable(Suspect suspect) {
        Double weight = suspect.getWeight();
        Double volume = suspect.getVolume();

        return (weight / volume) < InterestingFacts.WATER_DENSITY;
    }

    static boolean isDuckWeight(Suspect suspect) {
        return suspect.getWeight()
                .equals(InterestingFacts.DUCK_WEIGHT);
    }

    static boolean isMadeOfWood(Suspect suspect) {
        return suspect.getProperties().stream()
                .anyMatch(p -> p.contains("wood"));
    }
}
