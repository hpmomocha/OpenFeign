package com.hpe.kevin.controller;

import com.hpe.kevin.controller.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @RequestMapping("/addUser/{userId}/{userName}")
    public UserDTO addUser(
            @PathVariable("userId") Long UserId,
            @PathVariable("userName") String userName) {
        return new UserDTO(UserId.longValue(), userName);
    }

    // 基本类型传参
    @RequestMapping(value = "/addUser1", method = RequestMethod.POST)
    public UserDTO addUser1(Long userId, String userName) {
        return new UserDTO(userId.longValue(), userName);
    }

    // 实体传参
    @RequestMapping(value = "/addUser2", method = RequestMethod.POST)
    public UserDTO addUser2(@RequestBody UserDTO userDTO) {
        return userDTO;
    }
}
