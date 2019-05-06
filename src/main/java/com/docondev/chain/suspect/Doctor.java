package com.docondev.chain.suspect;

class Doctor {
    private Name name = new Name("");

    String getLastName() {
        return this.name.getLastName();
    }

    void setName(String fullName) {
        this.name = new Name(fullName);
    }

    String getFirstName() {
        return this.name.getFirstName();
    }
}

class Name {
    private String firstName;
    private String lastName;

    Name(String fullName) {
        String[] splitName = fullName.split(" ");
        firstName = splitName.length > 0 ? splitName[0] : "";
        lastName = splitName.length > 1 ? splitName[1] : "";
    }

    String getLastName() {
        return this.lastName;
    }

    String getFirstName() {
        return this.firstName;
    }
}