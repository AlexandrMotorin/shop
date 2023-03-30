package com.example.shop.service.intfs;

import com.example.shop.entity.Product;
import com.example.shop.models.ProductDto;
import com.example.shop.models.ProductInfo;

import java.util.List;

public interface ProductService {


    List<ProductDto> findAll();

    ProductInfo getProductInfo(Long productId, Long clientId);

    void evaluateProduct(Long clientId, Long productId, Integer value);

    Product getRandomProduct();

}
