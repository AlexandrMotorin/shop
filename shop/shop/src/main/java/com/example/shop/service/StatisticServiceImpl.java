package com.example.shop.service;

import com.example.shop.enums.StatisticType;
import com.example.shop.models.Statistic;
import com.example.shop.repository.ClientRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.intfs.ClientService;
import com.example.shop.service.intfs.ProductService;
import com.example.shop.service.intfs.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StatisticServiceImpl implements StatisticService {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public StatisticServiceImpl(ProductRepository productRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Statistic getStatistic(StatisticType type, long id) {

        switch (type){
            case PRODUCT: return productRepository.getProductStatistic(id);
            case CLIENT: return clientRepository.getClientStatistic(id);
        }

        return null;
    }
}
