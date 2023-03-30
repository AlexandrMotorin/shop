package com.example.shop.service;

import com.example.shop.entity.Client;
import com.example.shop.entity.Position;
import com.example.shop.entity.Product;
import com.example.shop.entity.RandomDiscount;
import com.example.shop.exception.BadRequestException;
import com.example.shop.exception.InternalServerException;
import com.example.shop.models.DealDto;
import com.example.shop.models.DealIndex;
import com.example.shop.repository.ClientRepository;
import com.example.shop.repository.DealRepository;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.RandomDiscountRepository;
import com.example.shop.service.intfs.CalculationDealService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CalculationDealServiceImpl implements CalculationDealService {

    private final ClientRepository clientRepository;
    private final RandomDiscountRepository discountRepository;
    private final ProductRepository productRepository;
    private final DealRepository dealRepository;

    public CalculationDealServiceImpl(ClientRepository clientRepository, RandomDiscountRepository discountRepository, ProductRepository productRepository, DealRepository dealRepository) {
        this.clientRepository = clientRepository;
        this.discountRepository = discountRepository;
        this.productRepository = productRepository;
        this.dealRepository = dealRepository;
    }

    @Override
    public DealDto getDealDto(Map<Long, Integer> products, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new BadRequestException("Такого клиента нет"));

        RandomDiscount productDiscount = discountRepository.findActualDiscount()
                .orElseThrow(() -> new InternalServerException("Скидка не создана"));

        ArrayList<Long> ids = new ArrayList<>(products.keySet());
        List<Product> productsOfPositions = productRepository.findAllByIdIn(ids);

        List<Position> resultPositions = new ArrayList<>();
        int totalSum = 0;

        for(Map.Entry<Long, Integer> entry : products.entrySet()){

            Long productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productsOfPositions.stream()
                    .filter(p -> p.getId().equals(productId))
                    .findFirst()
                    .orElseThrow(() -> new BadRequestException("Продукт не найден"));

            Integer price = product.getPrice();
            Integer discount = computeDiscount(client, productDiscount, productId, quantity);

            int originalSum = price * quantity;
            int currentRealSum = computeWithDiscount(price, discount) * quantity;

            totalSum += currentRealSum;

            Position position = new Position(product, quantity, currentRealSum, originalSum, discount);
            resultPositions.add(position);
        }

        return new DealDto(resultPositions, totalSum);
    }

    @Override
    public String calculateCheckIndex() {

        DealIndex lastDealIndex = dealRepository.findLastDealIndex();

        if (lastDealIndex.getDate().toLocalDate().isBefore(LocalDate.now())) {
            return "00100";
        } else {
            Integer num = Integer.parseInt(lastDealIndex.getCheckNumber()) + 1;
            StringBuilder sb = new StringBuilder(String.valueOf(num));
            while (sb.length() < 5){
                sb.insert(0,"0");
            }
            return sb.toString();
        }
    }


    private int computeWithDiscount(Integer price, Integer discount) {
        return (price * ((100 - discount)) / 100);
    }


    private Integer computeDiscount(Client client, RandomDiscount productDiscount, Long currentProductId, Integer productCount) {
        int currentProductDiscount = productDiscount.getProduct().getId().equals(currentProductId)
                ? productDiscount.getDiscount()
                : 0;

        Integer clientDiscount = client.getDiscount1();
        if(client.getDiscount2() != 0 && productCount >= 5) clientDiscount = client.getDiscount2();

        int finalDiscount = currentProductDiscount + clientDiscount;
        return Math.min(finalDiscount, 18);
    }
}
