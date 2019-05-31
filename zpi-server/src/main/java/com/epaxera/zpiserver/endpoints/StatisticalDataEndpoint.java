package com.epaxera.zpiserver.endpoints;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/statistical-data", description = "Endpoint służący do obliczania miar statystycznych tj. mediana"
        + " dominanta, odchylenie standardowe i współczynnik zmienności za okres"
        + " ostatniego tygodnia, 2 tygodni, 1 miesiąca, 1 kwartału, pół roku oraz 1 roku dla wybranej przez"
        + " użytkownika waluty.")

@RestController(value = "/statistical-data")
public class StatisticalDataEndpoint {

}
