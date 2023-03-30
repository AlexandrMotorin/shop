package com.example.shop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String description;

    @ElementCollection
    @CollectionTable(name = "product_evaluations", joinColumns = @JoinColumn(name = "product_id"))
    private List<Evaluation> clientEvaluations = new ArrayList<>();

    public void addEvaluation(Evaluation evaluation) {
        clientEvaluations.add(evaluation);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Evaluation> getClientEvaluations() {
        return clientEvaluations;
    }

    public void setClientEvaluations(List<Evaluation> clientEvaluations) {
        this.clientEvaluations = clientEvaluations;
    }
}
