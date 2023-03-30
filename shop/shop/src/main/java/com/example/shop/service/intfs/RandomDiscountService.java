package com.example.shop.service.intfs;

import com.example.shop.entity.RandomDiscount;

public interface RandomDiscountService {

    RandomDiscount findActualDiscount();
    RandomDiscount updateActualDiscount();

}
