package com.example.shop.models;

import java.util.Map;

public class PositionsDto {

    private Map<Long, Integer> positions;
    private Integer totalSum;


    public Map<Long, Integer> getPositions() {
        return positions;
    }

    public void setPositions(Map<Long, Integer> positions) {
        this.positions = positions;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }
}
