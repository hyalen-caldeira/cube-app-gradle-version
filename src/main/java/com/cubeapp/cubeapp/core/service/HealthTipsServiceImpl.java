package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.client.dto.HealthTipsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HealthTipsServiceImpl implements HealthTipsService {
    @Autowired
    protected RestTemplate restTemplate;

    private final String BASE_URI = "/api/health-tips";

    @Override
    public List<HealthTipsDto> getSomeTips() {
        ResponseEntity<HealthTipsDto> response = restTemplate.getForEntity(BASE_URI, HealthTipsDto.class);

        return response.
    }
}
