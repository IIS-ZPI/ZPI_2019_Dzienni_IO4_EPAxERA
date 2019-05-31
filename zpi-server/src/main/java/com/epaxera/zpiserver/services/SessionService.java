package com.epaxera.zpiserver.services;

import com.epaxera.zpiserver.models.ExchangeRate;

public interface SessionService {

    ExchangeRate getLastQuotationOfTheAverageExchangeRate(String currency, String day);

}
