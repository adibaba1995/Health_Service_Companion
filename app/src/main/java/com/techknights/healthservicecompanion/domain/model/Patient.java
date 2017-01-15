package com.techknights.healthservicecompanion.domain.model;

import android.net.Uri;

/**
 * Created by adityathanekar on 10/01/17.
 */

public class Patient implements Data{

    private String name;
    private String phone;
    private Uri photo;

    public Patient() {

    }

    public Patient(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}
