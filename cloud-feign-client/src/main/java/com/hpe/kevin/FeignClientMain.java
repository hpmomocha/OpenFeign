package com.hpe.kevin;

import com.hpe.kevin.config.DefaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(defaultConfiguration = DefaultConfiguration.class)
public class FeignClientMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientMain.class,args);
    }
}