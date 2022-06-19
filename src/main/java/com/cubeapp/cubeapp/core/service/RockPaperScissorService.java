package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.commons.RockPaperScissorEnum;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorService {
    public RockPaperScissorEnum playGame(RockPaperScissorEnum throw1, RockPaperScissorEnum throw2) {
        if (throw1 == RockPaperScissorEnum.ROCK && throw2 == RockPaperScissorEnum.SCISSOR)
            return throw1;

        return null;
    }
}
