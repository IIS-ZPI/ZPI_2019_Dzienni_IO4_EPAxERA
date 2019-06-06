package com.epaxera.zpiserver.services;

public interface StatisticalDataService {

    Double getMedianOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day);

    Double getStandardDeviationOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day);

    Double getDominantOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day);

    Double getVariationOfChosenCurrencyForTimeSpecifiedInDayParameter(String currency, String day);

}
