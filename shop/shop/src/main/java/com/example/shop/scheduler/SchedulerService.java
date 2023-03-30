package com.example.shop.scheduler;

import com.example.shop.service.intfs.RandomDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {

    private final RandomDiscountService discountService;

    @Autowired
    public SchedulerService(RandomDiscountService discountService) {
        this.discountService = discountService;
    }

//    @Scheduled(cron = "0 * * * * *")
//    void updateDiscounts(){
//        discountService.updateActualDiscount();
//    }



}
