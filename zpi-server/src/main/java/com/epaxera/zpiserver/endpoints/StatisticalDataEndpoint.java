package com.epaxera.zpiserver.endpoints;

import com.epaxera.zpiserver.services.StatisticalDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "/statistical-data", description = "Endpoint służący do obliczania miar statystycznych tj. mediana"
        + " dominanta, odchylenie standardowe i współczynnik zmienności za okres"
        + " ostatniego tygodnia, 2 tygodni, 1 miesiąca, 1 kwartału, pół roku oraz 1 roku dla wybranej przez"
        + " użytkownika waluty.")

@RestController
@RequestMapping("/statistical-data")
public class StatisticalDataEndpoint {

    private StatisticalDataService statisticalDataService;

    @Autowired
    public StatisticalDataEndpoint(StatisticalDataService statisticalDataService) {
        this.statisticalDataService = statisticalDataService;
    }

    @RequestMapping(path = "/median/{currency}/{day}", method = RequestMethod.GET)
    public ResponseEntity<Double> getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(@PathVariable String currency, @PathVariable String day) {
        Double median = statisticalDataService.getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day);
        return new ResponseEntity<>(median, HttpStatus.OK);
    }

    @RequestMapping(path = "deviation/{currency}/{day}", method = RequestMethod.GET)
    public ResponseEntity<Double> getStandardDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(@PathVariable String currency, @PathVariable String day) {
        Double standardDeviation = statisticalDataService.getStandardDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day);
        return new ResponseEntity<>(standardDeviation, HttpStatus.OK);
    }

    @RequestMapping(path = "dominant/{currency}/{day}", method = RequestMethod.GET)
    public ResponseEntity<Double> getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(@PathVariable String currency, @PathVariable String day) {
        Double dominant = statisticalDataService.getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day);
        return new ResponseEntity<>(dominant, HttpStatus.OK);
    }

    @RequestMapping(path = "variation/{currency}/{day}", method = RequestMethod.GET)
    public ResponseEntity<Double> getVariationOfChosenCurrencyForTimeSpecifiedInDayParameter(@PathVariable String currency, @PathVariable String day) {
        Double variation = statisticalDataService.getVariationOfChosenCurrencyForTimeSpecifiedInDayParameter(currency, day);
        return new ResponseEntity<>(variation, HttpStatus.OK);
    }

}
