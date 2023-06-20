package com.hpe.kevin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置：当使用@Configuration会将配置作用所有的服务提供方
 * 局部配置：如果只想针对某一个服务进行配置，就不要加@Configuration
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 日志输出级别的输出内容:
        // FULL > HEADERS > BASIC > NONE
        // FULL = BASIC + HEADERS + 数据
        return Logger.Level.FULL;
    }
}
