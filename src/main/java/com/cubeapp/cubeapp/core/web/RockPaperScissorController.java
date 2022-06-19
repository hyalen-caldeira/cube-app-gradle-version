package com.cubeapp.cubeapp.core.web;

import com.cubeapp.cubeapp.commons.RockPaperScissorEnum;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.core.service.RockPaperScissorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userController_v1")
@RequestMapping(value = "/api/rps", produces = UserDto.MEDIA_TYPE)
@CrossOrigin
public class RockPaperScissorController {
//    @Autowired
    RockPaperScissorService service;

    RockPaperScissorController(RockPaperScissorService service) {
        this.service = service;
    }

    @GetMapping(value = "/throw")
    public String playGame(@RequestParam(value = "throw1") RockPaperScissorEnum throw1, @RequestParam(value = "throw2") RockPaperScissorEnum throw2) {

        RockPaperScissorEnum result = service.playGame(throw1, throw2);

        return result.toString();
    }
}
