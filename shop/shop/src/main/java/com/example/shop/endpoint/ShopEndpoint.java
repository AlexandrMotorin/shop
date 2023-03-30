package com.example.shop.endpoint;


import com.example.shop.entity.Deal;
import com.example.shop.enums.StatisticType;
import com.example.shop.models.ProductInfo;
import com.example.shop.models.Statistic;
import com.example.shop.service.intfs.ClientService;
import com.example.shop.service.intfs.DealService;
import com.example.shop.service.intfs.ProductService;
import com.example.shop.service.intfs.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Endpoint
public class ShopEndpoint {
//
//    private static final String NAMESPACE_URI = "http://www.shop.com/springsoap/gen";
//    private final ClientService clientService;
//    private final ProductService productService;
//    private final DealService dealService;
//    private final StatisticService statisticService;
//
//    @Autowired
//    public ShopEndpoint(ClientService clientService, ProductService productService, DealService dealService, StatisticService statisticService) {
//        this.clientService = clientService;
//        this.productService = productService;
//        this.dealService = dealService;
//        this.statisticService = statisticService;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientsRequest")
//    @ResponsePayload
//    public GetClientsResponse getClients() {
//
//        List<ClientModal> clientModals = clientService.findAll().stream().map(c -> {
//            ClientModal client = new ClientModal();
//            client.setId(c.getId());
//            client.setFirstname(c.getFirstname());
//            client.setLastname(c.getLastname());
//            client.setDiscount1(c.getDiscount1());
//            client.setDiscount2(c.getDiscount2());
//            return client;
//        }).collect(Collectors.toList());
//
//        GetClientsResponse response = new GetClientsResponse();
//        response.getClient().addAll(clientModals);
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "changeClientDiscountRequest")
//    public void changeClientDiscount(@RequestPayload ChangeClientDiscountRequest request) {
//        clientService.editClientDiscounts(request.getId(), request.getDiscount1(), request.getDiscount2());
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
//    @ResponsePayload
//    public GetProductsResponse getProducts() {
//        List<ProductModal> productList = productService.findAll().stream().map(p -> {
//            ProductModal product = new ProductModal();
//            product.setId(p.getId());
//            product.setName(p.getName());
//            product.setPrice(p.getPrice());
//            return product;
//        }).collect(Collectors.toList());
//
//        GetProductsResponse response = new GetProductsResponse();
//        response.getProduct().addAll(productList);
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductInfoRequest")
//    @ResponsePayload
//    public GetProductInfoResponse getProductInfo(@RequestPayload GetProductInfoRequest request) {
//
//        ProductInfo info = productService.getProductInfo(request.getProductId(), request.getClientId());
//
//        List<Distribution> distributions = info.getDistribution().entrySet().stream().map((e) -> {
//            Distribution distribution = new Distribution();
//            distribution.setEvaluation(e.getKey());
//            distribution.setQuantity(e.getValue());
//            return distribution;
//        }).collect(Collectors.toList());
//
//        ProductInfoModal productInfoModal = new ProductInfoModal();
//        productInfoModal.setDescription(info.getDescription());
//        productInfoModal.setAverageEvaluation(info.getAverageEvaluation());
//        productInfoModal.setClientEvaluation(info.getClientEvaluation());
//        productInfoModal.getDistributions().addAll(distributions);
//
//        GetProductInfoResponse response = new GetProductInfoResponse();
//        response.setProductInfoModal(productInfoModal);
//        return response;
//    }
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "totalSumRequest")
//    @ResponsePayload
//    public TotalSumResponse getTotalSum(@RequestPayload TotalSumRequest request) {
//
//        Map<Long, Integer> map = request.getPositions().stream().collect(Collectors.toMap(
//                p -> (long) p.getProductId(),
//                Position::getQuantity
//        ));
//
//        Integer totalCost = dealService.getTotalCost(map, request.getClientId());
//        TotalSumResponse response = new TotalSumResponse();
//        response.setTotalSum(totalCost);
//        return response;
//    }
//
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createDealRequest")
//    @ResponsePayload
//    public CreateDealResponse createDeal(@RequestPayload CreateDealRequest request){
//
//        Map<Long, Integer> map = request.getPositions().stream().collect(Collectors.toMap(
//                p -> (long) p.getProductId(),
//                Position::getQuantity
//        ));
//
//        Deal deal = dealService.createDeal(map, request.getTotalSum(), request.getClientId());
//
//        CreateDealResponse response = new CreateDealResponse();
//        response.setCheckId(deal.getCheckNumber());
//        return response;
//    }
//
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "evaluateProductRequest")
//    public void evaluateProduct(@RequestPayload EvaluateProductRequest request){
//        productService.evaluateProduct(request.getClientId(), request.getProductId(), request.getValue());
//    }
//
//
//    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getStatisticRequest")
//    public GetStatisticResponse getStatisticRequest(@RequestPayload GetStatisticRequest request) {
//
//        StatisticType statisticType = StatisticType.valueOf(request.getStatisticType().name());
//        Statistic statistic = statisticService.getStatistic(statisticType, request.getId());
//
//        GetStatisticResponse response = new GetStatisticResponse();
//        response.setCheckCount(statistic.getCheckCount());
//        response.setDiscountSum(statistic.getDiscountSum());
//        response.setTotalPrice(statistic.getTotalPrice());
//        return response;
//
//    }

}
