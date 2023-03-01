package com.appybuilder.alioffical.insurancebazar.Activitise.Models;

public class UserRegistration {
    String fname,email,pass;

    public UserRegistration(String fname, String email, String pass) {
        this.fname = fname;
        this.email = email;
        this.pass = pass;
    }

    public UserRegistration() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
