package com.example.shop.integration.service;

import com.example.shop.entity.Evaluation;
import com.example.shop.entity.Product;
import com.example.shop.integration.IntegrationTestBased;
import com.example.shop.models.ProductDto;
import com.example.shop.models.ProductInfo;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.intfs.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class ProductServiceTest extends IntegrationTestBased {

    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductServiceTest(ProductService productService,
                              ProductRepository productRepository
    ) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Test
    void findAllTest(){
        List<ProductDto> actualProducts = productService.findAll();
        assertThat(actualProducts).hasSize(6);
    }

    @Test
    void getProductInfoTest() {
        String exceptedAvg = "3,7";
        ProductInfo info = productService.getProductInfo(3L, 1L);

        assertThat(info.getDistribution()).hasSize(3);
        assertThat(info.getClientEvaluation()).isEqualTo(4);
        assertThat(info.getAverageEvaluation()).isEqualTo(exceptedAvg);
    }

    @Test
    void evaluateProduct() {
        long productId = 1L;
        long clientId = 1L;
        int value = 5;

        productService.evaluateProduct(clientId, productId, value);

        Optional<Product> byId = productRepository.findById(productId);

        assertThat(byId).isPresent();
        Product product = byId.get();

        Optional<Evaluation> evaluationOptional = product.getClientEvaluations().stream()
                .filter(ce -> ce.getClient().getId() == clientId)
                .findFirst();

        assertThat(evaluationOptional).isPresent();
        Integer evaluation = evaluationOptional.get().getEvaluation();
        assertThat(evaluation).isEqualTo(value);
    }
}

