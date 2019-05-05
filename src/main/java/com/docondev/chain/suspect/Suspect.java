package com.docondev.chain.suspect;

import java.util.List;

class Suspect {
    private List<String> properties;
    private Double weight = 178.4;
    private Double volume = 19.0;
    private List<String> hobbies;
    private Doctor doctor;

    Double getWeight() {
        return this.weight;
    }

    Double getVolume() {
        return this.volume;
    }

    List<String> getProperties() {
        return this.properties;
    }

    List<String> getHobbies() {
        return this.hobbies;
    }

    Doctor getDoctor() {
        return doctor;
    }

    String getHomeTown() {
        return null;
    }

    String getOccupation() {
        return null;
    }
}
