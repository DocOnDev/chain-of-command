package com.docondev.chain.suspect;

import java.util.ArrayList;
import java.util.List;

class Suspect {
    private List<String> properties = new ArrayList<>();
    private Double weight = 178.4;
    private Double volume = 19.0;
    private List<String> hobbies = new ArrayList<>();
    private Doctor doctor = new Doctor();
    private String homeTown = "";
    private String occupation = "";

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
        return this.doctor;
    }

    String getHomeTown() {
        return this.homeTown;
    }

    String getOccupation() {
        return this.occupation;
    }

    void setWeight(Double weight) {
        this.weight = weight;
    }

    void setVolume(Double volume) {
        this.volume = volume;
    }

    void addProperty(String property) {
        this.properties.add(property);
    }

    void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }
}
