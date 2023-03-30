package com.example.shop.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class Position {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private Integer quantity;

    private Integer totalPrice;

    private Integer originalPrice;

    private Integer discount;

    public Position() {
    }

    public Position(Product product, Integer quantity, Integer totalPrice, Integer originalPrice, Integer discount) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.originalPrice = originalPrice;
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
