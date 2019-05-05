package com.docondev.chain.suspect;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DoctorTest {

    @Test
    public void confirmDoctorHasLastName() {
        Doctor doctor = new Doctor();
        doctor.setName("Jonas Jones");
        assertThat(doctor.getLastName(), is(equalTo("Jones")));
    }
}
