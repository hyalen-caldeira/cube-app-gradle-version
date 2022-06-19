package com.cubeapp.cubeapp.core.web

import com.cubeapp.cubeapp.commons.RockPaperScissorEnum
import com.cubeapp.cubeapp.core.service.RockPaperScissorService
import spock.lang.Specification
import org.mockito.InjectMocks
import org.mockito.Mock
import com.cubeapp.cubeapp.core.web.RockPaperScissorController
import static org.mockito.Mockito.when;

class RockPaperScissorControllerTest extends Specification {
    def rpsController
    def service

    def setup() {
        service = Mock(RockPaperScissorService)
        rpsController = new RockPaperScissorController(service)
        // rpsController.service.playGame(throw1, throw2) >> RockPaperScissorEnum.ROCK
//        when.(service.playGame("", "")).thenReturn("ROCK")
    }

    def "should call RPS service and return paper when playGame is called"() {
        given:
        def throw1 = RockPaperScissorEnum.ROCK
        def throw2 = RockPaperScissorEnum.SCISSOR

        when:
        service.playGame(throw1, throw2) >> RockPaperScissorEnum.ROCK
        def result = rpsController.playGame(throw1, throw2)

        then:
        result == "ROCK"
    }
}
