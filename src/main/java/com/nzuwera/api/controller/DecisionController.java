package com.nzuwera.api.controller;

import com.nzuwera.api.domain.OrderRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DecisionController.class);
    private final KieContainer kieContainer;

    public DecisionController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @PostMapping("/discount")
    private OrderRequest getDiscountPercentage(@RequestBody OrderRequest orderRequest) {
        LOGGER.error("request {}",orderRequest);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        LOGGER.error("response {}",orderRequest);
        return orderRequest;
    }
}
