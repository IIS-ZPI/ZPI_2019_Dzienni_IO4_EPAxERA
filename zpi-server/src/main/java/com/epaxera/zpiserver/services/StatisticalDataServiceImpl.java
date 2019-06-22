package com.epaxera.zpiserver.services;

import com.epaxera.zpiserver.models.ExchangeRate;
import com.epaxera.zpiserver.models.Rate;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StatisticalDataServiceImpl implements StatisticalDataService {

    private RestTemplate restTemplate;

    @Autowired
    public StatisticalDataServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Double getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day) {
        ExchangeRate result = restTemplate.getForObject(
                "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + day + "/?format=json", ExchangeRate.class, currency,
                day);

        List<Double> midFromRates = convertMidDataToDouble(result.getRates());

        double median;
        Collections.sort(midFromRates);
        if (midFromRates.size() % 2 == 0) {
            median = (midFromRates.get(midFromRates.size() / 2) + midFromRates.get(midFromRates.size() / 2 - 1)) / 2;
        } else {
            median = midFromRates.get(midFromRates.size() / 2);
        }

        return median;
    }

    @Override
    public Double getStandardDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day) {
        ExchangeRate result = restTemplate.getForObject(
                "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + day + "/?format=json", ExchangeRate.class, currency,
                day);

        List<Double> midFromRates = convertMidDataToDouble(result.getRates());
        Double[] array = midFromRates.toArray(new Double[midFromRates.size()]);
        double[] smallDouble = ArrayUtils.toPrimitive(array);

        StandardDeviation standardDeviation = new StandardDeviation();

        return standardDeviation.evaluate(smallDouble);
    }

    @Override
    public Double getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day) {
        ExchangeRate result = restTemplate.getForObject(
                "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + day + "/?format=json", ExchangeRate.class, currency,
                day);

        List<Double> midFromRates = convertMidDataToDouble(result.getRates());
        double dominant = 0.0;
        double max = 0.0;
        int counter;

        for (int i = 0; i < midFromRates.size(); i++) {
            counter = 0;
            for (int j = 0; j < midFromRates.size(); j++) {
                if (midFromRates.get(i) == midFromRates.get(j)) {
                    counter++;
                    if (counter > max) {
                        dominant = midFromRates.get(i);
                        max = counter;
                    }
                }
            }
        }

        return dominant;
    }

    @Override
    public Double getVariationOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day) {
        ExchangeRate result = restTemplate.getForObject(
                "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/last/" + day + "/?format=json", ExchangeRate.class, currency,
                day);

        List<Double> midFromRates = convertMidDataToDouble(result.getRates());
        Double[] array = midFromRates.toArray(new Double[midFromRates.size()]);
        double[] smallDouble = ArrayUtils.toPrimitive(array);
        double sum = 0;
        StandardDeviation standardDeviation = new StandardDeviation();

        for (int i = 0; i < midFromRates.size(); i++) {
            sum = sum + midFromRates.get(i);
        }

        return standardDeviation.evaluate(smallDouble)/(sum/midFromRates.size());
    }

    private List<Double> convertMidDataToDouble(List<Rate> rates) {
        List<Double> result = new ArrayList<>();

        for (Rate rate : rates) {
            result.add(Double.valueOf(rate.getMid()));
        }

        return result;
    }

}
