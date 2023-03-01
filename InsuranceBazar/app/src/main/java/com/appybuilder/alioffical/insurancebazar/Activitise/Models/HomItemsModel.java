package com.appybuilder.alioffical.insurancebazar.Activitise.Models;

public class HomItemsModel {
    String name;
    String image_url;
    String policy;

    public HomItemsModel(String name, String image_url, String policy) {
        this.name = name;
        this.image_url = image_url;
        this.policy = policy;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public HomItemsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
