package com.hpe.kevin.controller;

import com.hpe.kevin.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestPostController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/postForObject1")
    public UserDTO postForObject1() {
        String url = "http://localhost:9000/addUser1";
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("userId", 99999L);
        multiValueMap.add("userName", "Kevin");

        UserDTO userDTO = restTemplate.postForObject(url, multiValueMap, UserDTO.class);

        return userDTO;
    }

    @GetMapping("/postForObject2")
    public UserDTO postForObject2() {
        String url = "http://localhost:9000/addUser2";

        UserDTO paramUserDTO = new UserDTO(88888L, "Lorraine");

        UserDTO userDTO = restTemplate.postForObject(url, paramUserDTO, UserDTO.class);

        return userDTO;
    }

    @GetMapping("/postForObject3")
    public UserDTO postForObject3() {
        String url = "http://localhost:9000/addUser2";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserDTO paramUserDTO = new UserDTO(77777L, "Trump");

//        // 如果没有 header 参数, 可以不写
//        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(paramUserDTO);
        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(paramUserDTO, headers);

        UserDTO userDTO = restTemplate.postForObject(url, httpEntity, UserDTO.class);

        return userDTO;
    }

    @GetMapping("/postForEntity1")
    public UserDTO postForEntity1() {
        String url = "http://localhost:9000/addUser2";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserDTO paramUserDTO = new UserDTO(77777L, "Trump");

        HttpEntity<UserDTO> httpEntity = new HttpEntity<>(paramUserDTO, headers);

        ResponseEntity<UserDTO> userDTOResponseEntity = restTemplate.postForEntity(url, httpEntity, UserDTO.class);

        HttpStatus statusCode = userDTOResponseEntity.getStatusCode();
        int statusCodeValue = userDTOResponseEntity.getStatusCodeValue();
        HttpHeaders responseHeaders = userDTOResponseEntity.getHeaders();

        return userDTOResponseEntity.getBody();
    }
}
