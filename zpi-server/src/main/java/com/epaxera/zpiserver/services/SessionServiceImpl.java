package com.epaxera.zpiserver.services;

import com.epaxera.zpiserver.models.ExchangeRate;
import com.epaxera.zpiserver.services.error.URLNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SessionServiceImpl implements SessionService {

    private RestTemplate restTemplate;

    @Autowired public SessionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override public ExchangeRate getLastQuotationOfTheAverageExchangeRate(String currency, String day) {
        ExchangeRate result = restTemplate.getForObject(
                "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + day + "/?format=json", ExchangeRate.class, currency,
                day);

        if (result == null) {
            throw new URLNotFound("Nie znaleziono danych dla takich parametrów.");
        }

        return result;
    }

}
