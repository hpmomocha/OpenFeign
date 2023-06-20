package com.hpe.kevin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOldAnnotationServerController {
    @GetMapping(value = "/feign-old-annotation/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return "feign-old-annotation===>id=" + id;
    }
}
