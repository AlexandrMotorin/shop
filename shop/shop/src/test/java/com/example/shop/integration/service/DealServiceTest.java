package com.example.shop.integration.service;

import com.example.shop.entity.Deal;
import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.service.intfs.DealService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealServiceTest extends IntegrationTestBased {

    private final DealService dealService;


    @Autowired
    public DealServiceTest(DealService dealService) {
        this.dealService = dealService;
    }

    @Test
    void createDealTest() {

        Long expectedId = 3L;
        Integer sum = 6100;

        HashMap<Long, Integer> products = new HashMap<>();
        Long clientId = 1L;

        products.put(1L, 2);
        products.put(2L, 1);

        Deal deal = dealService.createDeal(products, sum, clientId);

        assertEquals(expectedId, deal.getId());
    }

    @Test
    void getTotalCostTest() {

        Integer exceptedSum = 6100;

        HashMap<Long, Integer> products = new HashMap<>();
        Long clientId = 1L;

        products.put(1L, 2);
        products.put(2L, 1);

        Integer totalCost = dealService.getTotalCost(products, clientId);
        assertEquals(exceptedSum, totalCost);
    }

}
