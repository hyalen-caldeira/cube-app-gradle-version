package com.cubeapp.cubeapp.core.service

import com.cubeapp.cubeapp.commons.RockPaperScissorEnum
import spock.lang.Specification

class RockPaperScissorServiceTest extends Specification {
    def service

    def setup() {
        service = new RockPaperScissorService();
    }

    def "should return Rock when throw1 is Rock and throw2 is Scissor"() {
        given:
        def throw1 = RockPaperScissorEnum.ROCK
        def throw2 = RockPaperScissorEnum.SCISSOR
        // def service = new RockPaperScissorService();

        when:
        def result = service.playGame(throw1, throw2);

        then:
        result == RockPaperScissorEnum.ROCK
    }

    def "something"() {
        expect:
        result == service.playGame(throw1, throw2)
        where:
        throw1                    | throw2                     | result
        RockPaperScissorEnum.ROCK | RockPaperScissorEnum.SCISSOR | RockPaperScissorEnum.ROCK
    }
}
