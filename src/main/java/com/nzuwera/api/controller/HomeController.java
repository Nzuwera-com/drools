package com.nzuwera.api.controller;

import com.nzuwera.api.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private WelcomeService welcomeService;

    @Autowired
    public HomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/")
    public String hello(){
        return welcomeService.getWelcomeMessage();
    }
}
