package com.hpe.kevin.service;

import com.hpe.kevin.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// http://localhost:9000/consumer/feign/user/get/1
@FeignClient(value = "cloud-feign-server", contextId = "user")
public interface UserService {
    @GetMapping(value = "/user/get/{id}")
    User getUserById(@PathVariable("id") Long id);
}
