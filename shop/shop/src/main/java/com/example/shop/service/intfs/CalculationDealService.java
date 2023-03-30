package com.example.shop.service.intfs;

import com.example.shop.models.DealDto;

import java.util.Map;

public interface CalculationDealService {

    DealDto getDealDto(Map<Long, Integer> products, Long clientId);
    String calculateCheckIndex();

}
