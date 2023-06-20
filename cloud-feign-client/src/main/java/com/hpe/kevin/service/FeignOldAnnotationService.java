package com.hpe.kevin.service;

import com.hpe.kevin.config.FeignOldAnnotationConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "cloud-feign-server",
        contextId = "feign-old-annotation-service",
        path = "/feign-old-annotation",
        configuration = FeignOldAnnotationConfiguration.class)
public interface FeignOldAnnotationService {
    @RequestLine("GET /get/{id}")
    public String get(@Param("id") Long id);
}
