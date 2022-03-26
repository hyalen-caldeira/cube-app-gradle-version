package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthTipsServiceImpl implements HealthTipsService {
    @Autowired
    protected RestTemplate restTemplate;

    private final String HOST_PORT = "http://localhost:8081";
    private final String BASE_URI = "/api/health-tips";

    @Override
    public List<String> getHealthTips() {
        ResponseEntity<List<HealthTipsDto>> responseEntity = restTemplate.exchange(
                HOST_PORT + BASE_URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HealthTipsDto>>() {}
        );

        List<HealthTipsDto> tips = responseEntity.getBody();

        return tips.stream()
                .map(HealthTipsDto::getTip)
                .collect(Collectors.toList());

        // ResponseEntity<HealthTipsDto> response = restTemplate.getForEntity(HOST_PORT + BASE_URI, HealthTipsDto.class);

    }
}
