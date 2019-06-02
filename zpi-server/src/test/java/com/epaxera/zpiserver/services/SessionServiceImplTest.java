package com.epaxera.zpiserver.services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


public class SessionServiceImplTest {

    private SessionService sessionService;

    @Before
    public void setUp(){
        RestTemplate restTemplate = new RestTemplate();
        sessionService = new SessionServiceImpl(restTemplate);
    }

    @Test(expected = HttpClientErrorException.class)
    public void shouldReturnTrueIfParametersAreIncorrect(){
        sessionService.getLastQuotationOfTheAverageExchangeRate("USD","0");
    }
}