package com.example.shop.service;

import com.example.shop.entity.Client;
import com.example.shop.exception.BadRequestException;
import com.example.shop.models.Statistic;
import com.example.shop.repository.ClientRepository;
import com.example.shop.service.intfs.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void editClientDiscounts(Long id, Integer discount1, Integer discount2) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Такой клиент не найден"));

        client.setDiscount1(discount1);
        client.setDiscount2(discount2);
    }

}
