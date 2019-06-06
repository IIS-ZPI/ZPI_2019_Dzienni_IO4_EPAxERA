package com.epaxera.zpiserver;

import com.epaxera.zpiserver.services.SessionService;
import com.epaxera.zpiserver.services.SessionServiceImpl;
import com.epaxera.zpiserver.services.StatisticalDataService;
import com.epaxera.zpiserver.services.StatisticalDataServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ZpiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZpiServerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public SessionService sessionService() {
		return new SessionServiceImpl(restTemplate());
	}

	@Bean
	public StatisticalDataService statisticalDataService() {
		return new StatisticalDataServiceImpl(restTemplate());
	}

}
