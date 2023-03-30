package com.example.shop.models;

import java.util.Map;

public class ProductInfo {

    private String description;
    private String averageEvaluation;
    private Map<Integer, Integer> distribution;

    private Integer clientEvaluation;

    public ProductInfo() {
    }

    public ProductInfo(String description, String averageEvaluation, Map<Integer, Integer> distribution, Integer clientEvaluation) {
        this.description = description;
        this.averageEvaluation = averageEvaluation;
        this.distribution = distribution;
        this.clientEvaluation = clientEvaluation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAverageEvaluation() {
        return averageEvaluation;
    }

    public void setAverageEvaluation(String averageEvaluation) {
        this.averageEvaluation = averageEvaluation;
    }

    public Map<Integer, Integer> getDistribution() {
        return distribution;
    }

    public void setDistribution(Map<Integer, Integer> distribution) {
        this.distribution = distribution;
    }

    public Integer getClientEvaluation() {
        return clientEvaluation;
    }

    public void setClientEvaluation(Integer clientEvaluation) {
        this.clientEvaluation = clientEvaluation;
    }
}
