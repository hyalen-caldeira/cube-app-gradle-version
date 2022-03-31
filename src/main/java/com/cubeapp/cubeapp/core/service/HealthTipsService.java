package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto;

import java.util.List;

public interface HealthTipsService {
    List<HealthTipsDto> getHealthTips();
    List<HealthTipsDto> getHealthTipsByUserId(long id);
}
