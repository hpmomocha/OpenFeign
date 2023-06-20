package com.hpe.kevin.controller;

import com.hpe.kevin.Result;
import com.hpe.kevin.service.FeignOldAnnotationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignOldAnnotationClientController {
    @Resource
    private FeignOldAnnotationService feignOldAnnotationService;

    @GetMapping(value = "/consumer/feign/feign-old-annotation/get/{id}")
    public Result<String> getOrderById(@PathVariable("id") Long id) {
        String str = feignOldAnnotationService.get(id);
        return new Result<>(str);
    }
}
