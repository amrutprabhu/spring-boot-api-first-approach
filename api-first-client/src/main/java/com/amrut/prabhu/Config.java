package com.amrut.prabhu;

import com.amrut.prabhu.api.AccountApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }

    @Bean
    public ApiClient apiclient(@Value("${accountApiUrl}")String basePath,RestTemplate restTemplate) {
        ApiClient apiclient = new ApiClient(restTemplate);
        apiclient.setBasePath(basePath);
        return apiclient;
    }

    @Bean
    public AccountApi accountApi(ApiClient apiClient){
        return new AccountApi(apiClient);
    }
}