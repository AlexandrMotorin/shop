package com.example.shop.service.intfs;

import com.example.shop.entity.Deal;

import java.util.Map;

public interface DealService {

    Deal createDeal(Map<Long, Integer> products, Integer totalCost, Long clientId);

    Integer getTotalCost(Map<Long, Integer> products, Long clientId);

}
