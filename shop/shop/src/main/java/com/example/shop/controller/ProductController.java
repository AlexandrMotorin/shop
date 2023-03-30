package com.example.shop.controller;

import com.example.shop.models.ProductDto;
import com.example.shop.models.ProductInfo;
import com.example.shop.service.intfs.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ProductInfo getProductInfo(@PathVariable Long productId, @RequestParam(name = "clientId") Long clientId) {
        return productService.getProductInfo(productId, clientId);
    }

}
