package com.example.shop.models;

import com.example.shop.entity.Position;

import java.util.List;

public class DealDto {

    private List<Position> positions;

    public Integer getTotalSum() {
        return totalSum;
    }

    public DealDto(List<Position> positions, Integer totalSum) {
        this.positions = positions;
        this.totalSum = totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    private Integer totalSum;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
