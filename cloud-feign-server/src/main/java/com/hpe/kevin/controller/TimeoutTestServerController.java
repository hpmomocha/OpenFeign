package com.hpe.kevin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeoutTestServerController {
    @GetMapping(value = "/timeoutTest/{id}")
    public String testTimeout(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(3000);
        return "accepted one msg id = " + id;
    }
}
