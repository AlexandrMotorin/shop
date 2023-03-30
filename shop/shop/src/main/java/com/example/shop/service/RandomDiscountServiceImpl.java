package com.example.shop.service;

import com.example.shop.entity.Product;
import com.example.shop.entity.RandomDiscount;
import com.example.shop.exception.InternalServerException;
import com.example.shop.repository.RandomDiscountRepository;
import com.example.shop.service.intfs.ProductService;
import com.example.shop.service.intfs.RandomDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
public class RandomDiscountServiceImpl implements RandomDiscountService {

    private final RandomDiscountRepository randomDiscountRepository;
    private final ProductService productService;

    @Autowired
    public RandomDiscountServiceImpl(RandomDiscountRepository randomDiscountRepository, ProductService productService) {
        this.randomDiscountRepository = randomDiscountRepository;
        this.productService = productService;
    }

    @Override
    public RandomDiscount findActualDiscount() {
        return randomDiscountRepository.findActualDiscount()
                .orElseThrow(() -> new InternalServerException("Ошибка получения ежедневной скидки"));
    }

    @Override
    public RandomDiscount updateActualDiscount() {
        Product product = productService.getRandomProduct();

        Random generator = new Random();
        int randomDiscount = generator.nextInt(10) + 5;

        RandomDiscount discount = new RandomDiscount();
        discount.setProduct(product);
        discount.setDiscount(randomDiscount);

        return randomDiscountRepository.save(discount);
    }
}
