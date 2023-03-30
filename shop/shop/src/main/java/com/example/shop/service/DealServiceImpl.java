package com.example.shop.service;

import com.example.shop.entity.Deal;
import com.example.shop.exception.BadRequestException;
import com.example.shop.models.DealDto;
import com.example.shop.models.DealIndex;
import com.example.shop.repository.ClientRepository;
import com.example.shop.repository.DealRepository;
import com.example.shop.service.intfs.CalculationDealService;
import com.example.shop.service.intfs.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
@Transactional
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final CalculationDealService calculationDealService;
    private final ClientRepository clientRepository;

    @Autowired
    public DealServiceImpl(DealRepository dealRepository, CalculationDealService calculationDealService, ClientRepository clientRepository) {
        this.dealRepository = dealRepository;
        this.calculationDealService = calculationDealService;
        this.clientRepository = clientRepository;
    }

    @Override
    public Deal createDeal(Map<Long, Integer> products, Integer totalCost, Long clientId) {

        DealDto dealDto = calculationDealService.getDealDto(products, clientId);
        if (!dealDto.getTotalSum().equals(totalCost))
            throw new BadRequestException("Итоговые суммы не совпали");

        String checkIndex = calculationDealService.calculateCheckIndex();

        Deal deal = new Deal();
        deal.setDealDate(LocalDateTime.now());
        deal.setCheckNumber(checkIndex);
        deal.setClient(clientRepository.getReferenceById(clientId));
        deal.setPositions(dealDto.getPositions());

        return dealRepository.save(deal);
    }

    @Override
    public Integer getTotalCost(Map<Long, Integer> products, Long clientId){
        DealDto dealDto = calculationDealService.getDealDto(products, clientId);
        return dealDto.getTotalSum();
    }

}
