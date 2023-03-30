package com.example.shop.integration.service;

import com.example.shop.entity.RandomDiscount;
import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.service.intfs.RandomDiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RandomDiscountServiceTest extends IntegrationTestBased {

    private final RandomDiscountService discountService;

    @Autowired
    public RandomDiscountServiceTest(RandomDiscountService discountService) {
        this.discountService = discountService;
    }

    @Test
    void updateActualDiscountTest() {
        RandomDiscount discount = discountService.updateActualDiscount();
        Assertions.assertNotNull(discount.getId());
    }
}
