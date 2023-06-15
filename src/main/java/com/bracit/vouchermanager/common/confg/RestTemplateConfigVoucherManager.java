package com.bracit.vouchermanager.common.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfigVoucherManager {

    @Bean
    public RestTemplate restTemplateVoucherManager() {
        return new RestTemplate();
    }
}
