package com.example.shop.models;

public class Statistic {

    private Integer checkCount;
    private Integer totalPrice;
    private Integer discountSum;

    public Statistic() {
    }

    public Statistic(Integer checkCount, Integer totalPrice, Integer discountSum) {
        this.checkCount = checkCount;
        this.totalPrice = totalPrice;
        this.discountSum = discountSum;
    }

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(Integer discountSum) {
        this.discountSum = discountSum;
    }
}
