package com.example.shop.integration.service;

import com.example.shop.entity.Client;
import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.service.intfs.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class ClientServiceTest extends IntegrationTestBased {

    private final ClientService clientService;
    private final EntityManager entityManager;

    @Autowired
    public ClientServiceTest(ClientService clientService, EntityManager entityManager) {
        this.clientService = clientService;
        this.entityManager = entityManager;
    }

    @Test
    public void editClientDiscountsTest() {

        long clientId = 1L;
        int expectedDiscount1 = 80;
        int expectedDiscount2 = 80;

        clientService.editClientDiscounts(clientId, expectedDiscount1, expectedDiscount2);
        entityManager.flush();
        entityManager.clear();

        Client client = entityManager.find(Client.class, 1L);

        Assertions.assertEquals(expectedDiscount1,client.getDiscount1() );
        Assertions.assertEquals(expectedDiscount2, client.getDiscount2());
    }

}
