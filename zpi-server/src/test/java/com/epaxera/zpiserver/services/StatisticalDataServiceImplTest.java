package com.epaxera.zpiserver.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;


public class StatisticalDataServiceImplTest {

    private StatisticalDataService statisticalDataService;
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        statisticalDataService = new StatisticalDataServiceImpl(restTemplate);
    }

    @Test
    public void shouldReturnCorrectMediana() {
        String currency = "gbp";
        String day = "7";
        Double result = 4.8270;

        Assert.assertEquals(statisticalDataService.getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day), result);
    }

    @Test
    public void shouldReturnCorrectStandardDeviation() {
        String currency = "gbp";
        String day = "7";
        Double result = 0.021084738330749815;

        Assert.assertEquals(statisticalDataService.getStandardDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day), result);
    }

    @Test
    public void shouldReturnCorrectDominant() {
        String currency = "gbp";
        String day = "7";
        Double result = 4.8572;

        Assert.assertEquals(statisticalDataService.getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day), result);
    }
}