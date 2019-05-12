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

    void setWeight(Double weight) {
        this.weight = weight;
    }

    Double getWeight() {
        return this.weight;
    }

    void setVolume(Double volume) {
        this.volume = volume;
    }

    Double getVolume() {
        return this.volume;
    }

    void addProperty(String property) {
        this.properties.add(property);
    }

    List<String> getProperties() {
        return this.properties;
    }

    void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    List<String> getHobbies() {
        return this.hobbies;
    }

    void setDoctor(String fullName) {
        this.doctor.setName(fullName);
    }

    Doctor getDoctor() {
        return this.doctor;
    }

    void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    String getHomeTown() {
        return this.homeTown;
    }

    void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    String getOccupation() {
        return this.occupation;
    }

    boolean hasProperty(String desiredProperty) {
        return getProperties().stream()
                .anyMatch(p -> p.contains(desiredProperty));
    }
}
