package com.example.shop.service.intfs;

import com.example.shop.enums.StatisticType;
import com.example.shop.models.Statistic;

public interface StatisticService {

    Statistic getStatistic(StatisticType type, long id);

}
