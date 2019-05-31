package com.epaxera.zpiserver.endpoints;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/changes-distribution", description = "Endpoint służący do wyznaczania miesięcznych i kwartalnych "
        + " zmian rozkładu w dowolnych parach walut wybranych przez użytkownika np. EUR/USD."
        + " Wyznaczanie polega na wyliczeniu w kolejnym dniu sesji zmian względem dnia poprzedniego.")


@RestController(value = "/changes-distribution")
public class CurrencyChangesDistributionEndpoint {

}
