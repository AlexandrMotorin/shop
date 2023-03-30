package com.example.shop.enums;

import com.example.shop.exception.BadRequestException;

public enum StatisticType {
    CLIENT("client"),
    PRODUCT("product");

    private final String name;

    StatisticType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static StatisticType getByName(String name) {
        try {
            return StatisticType.valueOf(name);
        } catch (Exception ex) {
            throw new BadRequestException("Тип статистики не существет");
        }
    }

}
