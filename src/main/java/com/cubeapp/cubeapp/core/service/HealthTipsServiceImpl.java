package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HealthTipsServiceImpl implements HealthTipsService {
    @Autowired
    protected RestTemplate restTemplate;

    private final String HOST_PORT = "http://localhost:8081";
    private final String BASE_URI = "/api/health-tips";

    @Override
    public List<HealthTipsDto> getHealthTips() {
        ResponseEntity<List<HealthTipsDto>> responseEntity = restTemplate.exchange(
                HOST_PORT + BASE_URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HealthTipsDto>>() {}
        );

        List<HealthTipsDto> tips = responseEntity.getBody();

        tips = shuffle(tips);

        return tips;
    }

    private List<HealthTipsDto> shuffle(List<HealthTipsDto> tips) {
        Random random = new Random();

        Map<Integer, HealthTipsDto> shuffledMap = new HashMap<>();

        for (int i = 0; i < tips.size(); i++)
            shuffledMap.put(i, tips.get(i));

        List<HealthTipsDto> shuffledList = new LinkedList<>();

        while (shuffledList.size() != 3) {
            int id = random.nextInt(shuffledMap.size());

            if (!shuffledList.contains(shuffledMap.get(id)))
                shuffledList.add(shuffledMap.get(id));
        }

        return shuffledList;
    }
}
