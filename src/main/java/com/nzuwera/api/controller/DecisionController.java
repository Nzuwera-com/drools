package com.nzuwera.api.controller;

import com.nzuwera.api.domain.OrderRequest;
import com.nzuwera.api.service.OrderService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DecisionController.class);
    private final KieContainer kieContainer;

    private OrderService service;

    @Autowired
    public DecisionController(OrderService service, KieContainer kieContainer) {
        this.service = service;
        this.kieContainer = kieContainer;
    }

    @PostMapping("/discount")
    public OrderRequest getDiscountPercentage(@RequestBody OrderRequest orderRequest) {
        LOGGER.info("request {}", orderRequest);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.info("response {}", orderRequest);
        service.logOrder(orderRequest);
        return orderRequest;
    }
}
