package com.hpe.kevin.controller;

import com.hpe.kevin.Result;
import com.hpe.kevin.service.TimeoutTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TimeoutTestClientController {
    @Resource
    private TimeoutTestService timeoutTestService;

    @GetMapping(value = "/consumer/feign/timeoutTest/{id}")
    public Result<String> testTimeout(@PathVariable("id") Long id) {
        String resultStr = timeoutTestService.testTimeout(id);
        return new Result<>(resultStr);
    }
}
