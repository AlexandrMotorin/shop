package com.example.shop.service.intfs;

import com.example.shop.entity.Client;
import com.example.shop.models.Statistic;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    void editClientDiscounts(Long id, Integer discount1, Integer discount2);
}
