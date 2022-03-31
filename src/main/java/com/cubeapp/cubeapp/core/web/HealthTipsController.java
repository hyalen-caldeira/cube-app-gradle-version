package com.cubeapp.cubeapp.core.web;

import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto;
import com.cubeapp.cubeapp.core.service.HealthTipsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<HealthTipsDto>> getHealthTips() {
        var list = service.getHealthTips();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<HealthTipsDto>> getHealthTipsByUserId(@PathVariable(value = "userId") long userId) {
        var tips = service.getHealthTipsByUserId(userId);

        return new ResponseEntity<>(tips, HttpStatus.OK);
    }
}