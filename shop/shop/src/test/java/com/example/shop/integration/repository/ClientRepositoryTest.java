package com.example.shop.integration.repository;

import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.models.Statistic;
import com.example.shop.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ClientRepositoryTest extends IntegrationTestBased {

    private final ClientRepository clientRepository;

    public ClientRepositoryTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Test
    void getClientStatisticTest() {

        Statistic statistic = clientRepository.getClientStatistic(3L);

        System.out.println();;

    }
}
