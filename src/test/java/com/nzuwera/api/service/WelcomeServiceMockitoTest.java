package com.nzuwera.api.service;

import com.nzuwera.api.controller.HomeController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class WelcomeServiceMockitoTest {

    @Mock
    private WelcomeService welcomeService;


    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    void setMockOutput(){
        when(welcomeService.getWelcomeMessage()).thenReturn("Welcome to Spring boot test");
    }

    @Test
    public void shouldReturnDefaultMessage(){
        String response = welcomeService.getWelcomeMessage();
        assertThat(response).isEqualTo("Welcome to Spring boot test");
    }
}
