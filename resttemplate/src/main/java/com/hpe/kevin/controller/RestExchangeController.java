package com.hpe.kevin.controller;

import com.hpe.kevin.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestExchangeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/exchange")
    public UserDTO exchange() {
        String url = "http://localhost:9000/addUser1";

        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("userId", 66666L);
        paramMap.add("userName", "Kevin666");

        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(paramMap);

        ResponseEntity<UserDTO> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, UserDTO.class);

        return response.getBody();
    }
}
