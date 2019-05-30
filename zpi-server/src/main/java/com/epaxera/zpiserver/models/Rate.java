package com.epaxera.zpiserver.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel
@Data
@Builder
public class Rate {

    @ApiModelProperty(position = 1, value = "Numer tabeli")
    private String no;

    @ApiModelProperty(position = 2, value = "Data publikacji")
    private String effectiveDate;

    @ApiModelProperty(position = 3, value = "Przeliczony kurs średni waluty (dotyczy tabel A oraz B)")
    private String mid;

}
