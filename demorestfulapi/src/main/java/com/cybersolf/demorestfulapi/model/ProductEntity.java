package com.cybersolf.demorestfulapi.model;

import com.cybersolf.demorestfulapi.controller.PolicyEntity;

import java.util.List;

public class ProductEntity {
    private String image;
    private String title;
    private Double price;
    private Double rate;
    private List<PolicyEntity> policies;

    public List<PolicyEntity> getPolicies() {
        return policies;
    }

    public void setPolicies(List<PolicyEntity> policies) {
        this.policies = policies;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
