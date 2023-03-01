package com.appybuilder.alioffical.insurancebazar.Activitise.Models;

public class HistoryModel {
    String policy,str_productname,product_img_url;

    public HistoryModel(String email, String str_productname, String product_img_url) {
        this.policy = email;
        this.str_productname = str_productname;
        this.product_img_url = product_img_url;
    }

    public HistoryModel() {
    }

    public String getEmail() {
        return policy;
    }

    public void setEmail(String email) {
        this.policy = email;
    }

    public String getStr_productname() {
        return str_productname;
    }

    public void setStr_productname(String str_productname) {
        this.str_productname = str_productname;
    }

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }
}
