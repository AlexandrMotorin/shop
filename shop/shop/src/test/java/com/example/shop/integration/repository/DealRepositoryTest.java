package com.example.shop.integration.repository;

import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.models.DealIndex;
import com.example.shop.repository.DealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealRepositoryTest extends IntegrationTestBased {

    private final DealRepository dealRepository;


    @Autowired
    public DealRepositoryTest(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Test
    void findLastDealIndexTest() {
        String expectedCheckNumber = "00101";
        DealIndex index = dealRepository.findLastDealIndex();

        assertEquals(expectedCheckNumber, index.getCheckNumber());
    }

}
