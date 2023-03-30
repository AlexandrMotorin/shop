package com.example.shop.controller;


import com.example.shop.enums.StatisticType;
import com.example.shop.models.Statistic;
import com.example.shop.service.intfs.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/{id}")
    public Statistic getStatistic(@PathVariable Long id,
                                  @RequestParam(name = "statisticTypeName") String statisticTypeName) {


        StatisticType statisticType = StatisticType.getByName(statisticTypeName);
        return statisticService.getStatistic(statisticType, id);

    }

}
