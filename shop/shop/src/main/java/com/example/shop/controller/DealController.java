package com.example.shop.controller;

import com.example.shop.entity.Deal;
import com.example.shop.models.PositionsDto;
import com.example.shop.service.intfs.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/deal")
public class DealController {

    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/total")
    public Integer getTotalSum(@RequestParam("positions") PositionsDto positions,
                               @RequestParam("clientId") Long clientId) {
        return dealService.getTotalCost(positions.getPositions(), clientId);
    }

    @PostMapping
    public String saveDeal(@RequestBody PositionsDto positions, @RequestParam("clientId") Long clientId){
        Deal deal = dealService.createDeal(positions.getPositions(), positions.getTotalSum(), clientId);
        return deal.getCheckNumber();
    }

}

