package com.hpe.kevin.controller;

import com.hpe.kevin.Result;
import com.hpe.kevin.User;
import com.hpe.kevin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserClientController {
    @Resource
    private UserService userService;

    @GetMapping(value = "/consumer/feign/user/get/{id}")
    public Result<User> getUserById(@PathVariable("id") Long id)
    {
        User user = userService.getUserById(id);
        return new Result<>(user);
    }
}
