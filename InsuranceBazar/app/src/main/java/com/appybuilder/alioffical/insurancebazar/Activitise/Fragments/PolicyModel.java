package com.appybuilder.alioffical.insurancebazar.Activitise.Fragments;

public class PolicyModel {
    String policyname;
    String policydes;

    public PolicyModel(String policyname, String policydes) {
        this.policyname = policyname;
        this.policydes = policydes;
    }

    public PolicyModel() {
    }

    public String getPolicyname() {
        return policyname;
    }

    public void setPolicyname(String policyname) {
        this.policyname = policyname;
    }

    public String getPolicydes() {
        return policydes;
    }

    public void setPolicydes(String policydes) {
        this.policydes = policydes;
    }
}
