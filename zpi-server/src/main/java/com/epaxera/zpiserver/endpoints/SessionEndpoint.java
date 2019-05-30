package com.epaxera.zpiserver.endpoints;

import com.epaxera.zpiserver.models.ExchangeRate;
import com.epaxera.zpiserver.services.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "/session", description = "Endpoint służący do wyznaczenia ilości sesji wzrostowych, spadkowych i bez zmian w okresach"
                                       + " ostatniego tygodnia, 2 tygodni, 1 miesiąca, 1 kwartału, pół roku oraz 1 roku dla wybranej przez"
                                       + "użytkownika waluty.")
@RestController()
@RequestMapping("/session")
public class SessionEndpoint {

    private SessionService sessionService;

    @Autowired
    public SessionEndpoint(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @ApiOperation(value = "Zwraca serię ostatnich {day} notowań kursu średniego waluty {currency}.")
    @ApiResponse(code = 200, message = "Pobrano serię ostatnich notowań kursu średniego danej waluty.", response = ExchangeRate.class)
    @RequestMapping(path = "/last-quotation/{currency}/{day}", method = RequestMethod.GET)
    ResponseEntity<ExchangeRate> getLastQuotationOfTheAverageExchangeRate(@PathVariable String currency, @PathVariable String day) {
        ExchangeRate result = sessionService.getLastQuotationOfTheAverageExchangeRate(currency, day);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
