package com.cubeapp.cubeapp.core.web;

import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto;
import com.cubeapp.cubeapp.core.service.HealthTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("healthTipsController_v1")
@RequestMapping(value = "/api/health-tips")
@CrossOrigin
public class HealthTipsController {
    private HealthTipsService service;

    public HealthTipsController(HealthTipsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<String>> getHealthTips() {
        var list = service.getHealthTips();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
