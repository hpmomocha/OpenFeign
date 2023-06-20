package com.hpe.kevin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-feign-server", contextId = "timeout")
public interface TimeoutTestService {
    @GetMapping(value = "/timeoutTest/{id}")
    String testTimeout(@PathVariable("id") Long id);
}
