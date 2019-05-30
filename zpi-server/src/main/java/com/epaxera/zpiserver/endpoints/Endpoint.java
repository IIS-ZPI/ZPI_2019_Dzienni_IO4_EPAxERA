package com.epaxera.zpiserver.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/example", description = "Przykładowy endpoints sprawdzający działanie specyfikacji Swagger")
@RestController(value = "/example")
public class Endpoint {

    @ApiOperation(value = "Przykładowa metoda sprawdzająca działanie specyfikacji Swagger")
    @ApiResponse(code = 200, message = "sample", response = String.class)
    @RequestMapping(value = "/sample", method = RequestMethod.POST)
    public String sample() {
        return "sample";
    }

}
