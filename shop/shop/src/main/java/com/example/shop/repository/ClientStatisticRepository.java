package com.example.shop.repository;

import com.example.shop.models.Statistic;

public interface ClientStatisticRepository {

    Statistic getClientStatistic(long clientId);

}
