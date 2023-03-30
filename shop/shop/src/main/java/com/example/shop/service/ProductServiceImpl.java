package com.example.shop.service;

import com.example.shop.entity.*;
import com.example.shop.exception.BadRequestException;
import com.example.shop.exception.InternalServerException;
import com.example.shop.models.DealDto;
import com.example.shop.models.ProductDto;
import com.example.shop.models.ProductInfo;
import com.example.shop.repository.ClientRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.RandomDiscountRepository;
import com.example.shop.service.intfs.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductInfo getProductInfo(Long productId, Long clientId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BadRequestException("Такой товар не найден"));

        OptionalDouble avgOptional = product.getClientEvaluations().stream()
                .mapToInt(Evaluation::getEvaluation)
                .average();

        if(!avgOptional.isPresent())
            return new ProductInfo(product.getDescription(), null, null, null);


        String avg = new DecimalFormat("#.#").format(avgOptional.getAsDouble());

        Map<Integer, Integer> map = product.getClientEvaluations().stream()
                .collect(Collectors.toMap(
                        Evaluation::getEvaluation,
                        e -> 1,
                        Integer::sum
                ));

        Optional<Evaluation> ev = product.getClientEvaluations().stream()
                .filter(e -> e.getClient().getId().equals(clientId))
                .findFirst();
        Integer clientEvaluation = ev.map(Evaluation::getEvaluation).orElse(null);

        return new ProductInfo(product.getDescription(), avg, map, clientEvaluation);
    }

    @Override
    public void evaluateProduct(Long clientId, Long productId, Integer value) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BadRequestException("Товар не существует"));

        Optional<Evaluation> currentEvaluation = product.getClientEvaluations().stream()
                .filter(ev -> ev.getClient().getId().equals(clientId))
                .findFirst();

        if(currentEvaluation.isPresent()) {
            currentEvaluation.get().setEvaluation(value);
        } else {
            Evaluation evaluation = new Evaluation();
            evaluation.setClient(clientRepository.getReferenceById(clientId));
            evaluation.setEvaluation(value);

            product.addEvaluation(evaluation);
        }
        productRepository.flush();
    }

    @Override
    public Product getRandomProduct() {
        List<Product> allProducts = productRepository.findAll();
        int randomIdx = new Random().nextInt(allProducts.size());

        return allProducts.get(randomIdx);
    }
}
