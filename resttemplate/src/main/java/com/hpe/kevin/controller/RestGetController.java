package com.hpe.kevin.controller;

import com.hpe.kevin.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestGetController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getForObject")
    public Object getForObject() {
        String url = "http://localhost:9000/addUser/10000/Lorraine";

        Map<String, Object> paramMap = new HashMap<>();
        UserDTO result = restTemplate.getForObject(url, UserDTO.class, paramMap);

        return result;
    }

    @GetMapping("getForEntity")
    public Map<String, Object> getForEntity() {
        String url = "http://localhost:9000/addUser/20000/Betty";

        Map<String, Object> paramMap = new HashMap<>();
        ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(url, HashMap.class, paramMap);
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();

        return responseEntity.getBody();
    }
}
