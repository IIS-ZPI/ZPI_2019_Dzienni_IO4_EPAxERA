package com.epaxera.zpiserver.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
@Builder
public class ExchangeRate {

    @ApiModelProperty(position = 1, value = "Typ tabeli")
    private String table;

    @ApiModelProperty(position = 2, value = "Nazwa waluty")
    private String currency;

    @ApiModelProperty(position = 3, value = "Kod waluty")
    private String code;

    @ApiModelProperty(position = 4, value = "Lista kursów poszczególnych walut w tabeli")
    private List<Rate> rates;

}
