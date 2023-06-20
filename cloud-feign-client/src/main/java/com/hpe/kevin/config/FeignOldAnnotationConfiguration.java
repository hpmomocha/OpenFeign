package com.hpe.kevin.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

public class FeignOldAnnotationConfiguration {
    // Feign 契约的配置类配置方式
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}
