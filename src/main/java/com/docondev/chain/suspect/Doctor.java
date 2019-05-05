package com.docondev.chain.suspect;

class Doctor {
    private Name name;

    String getLastName() {
        return name.getLastName();
    }

    void setName(String fullName) {
        this.name = new Name(fullName);
    }
}

class Name {
    private String firstName;
    private String lastName;

    Name(String fullName) {
        String[] splitName = fullName.split(" ");
        firstName = splitName[0];
        lastName = splitName[1];
    }

    String getLastName() {
        return this.lastName;
    }
}