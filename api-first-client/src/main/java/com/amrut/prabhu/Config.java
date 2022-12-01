package com.amrut.prabhu;

import com.amrut.prabhu.api.AccountApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }

    @Bean
    @Primary
    public ApiClient apiclient(RestTemplate restTemplate) {
        ApiClient apiclient = new ApiClient(restTemplate);
        apiclient.setBasePath("http://localhost:8080");
        return apiclient;

    }
}