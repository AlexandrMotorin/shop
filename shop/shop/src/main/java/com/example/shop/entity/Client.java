package com.example.shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    private Integer discount1;
    private Integer discount2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDiscount1() {
        return discount1;
    }

    public void setDiscount1(Integer discount1) {
        this.discount1 = discount1;
    }

    public Integer getDiscount2() {
        return discount2;
    }

    public void setDiscount2(Integer discount2) {
        this.discount2 = discount2;
    }
}
