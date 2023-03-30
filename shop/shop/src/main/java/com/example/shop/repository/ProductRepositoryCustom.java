package com.example.shop.repository;

import com.example.shop.models.Statistic;

public interface ProductRepositoryCustom {

    Statistic getProductStatistic(long productId);

}
