package com.docondev.chain.suspect;

public class VampireEvaluatorCommand extends AbstractEvaluatorCommand {
    @Override
    protected boolean shouldDetain(Suspect suspect) {
        return suspect.getDoctor().getLastName().equalsIgnoreCase("VanHelsing") &&
                suspect.getHomeTown().equals("Wallachian") &&
                suspect.getOccupation().equalsIgnoreCase("Prince");
    }
}
