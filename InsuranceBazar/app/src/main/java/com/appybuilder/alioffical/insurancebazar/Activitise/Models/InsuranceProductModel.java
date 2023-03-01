package com.appybuilder.alioffical.insurancebazar.Activitise.Models;

public class InsuranceProductModel {
    String str_product_name;
    String product_img_url;
    String des;
    String companyName;
    String policy;



    public InsuranceProductModel() {
    }

    public InsuranceProductModel(String str_product_name, String product_img_url, String des, String companyName, String policy) {
        this.str_product_name = str_product_name;
        this.product_img_url = product_img_url;
        this.des = des;
        this.companyName = companyName;
        this.policy = policy;
    }

    public String getStr_product_name() {
        return str_product_name;
    }

    public void setStr_product_name(String str_product_name) {
        this.str_product_name = str_product_name;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getStr_productname() {
        return str_product_name;
    }

    public void setStr_productname(String str_productname) {
        this.str_product_name = str_productname;
    }

    public String getProduct_img_url() {
        return product_img_url;
    }

    public void setProduct_img_url(String product_img_url) {
        this.product_img_url = product_img_url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
