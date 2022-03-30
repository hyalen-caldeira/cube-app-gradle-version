package com.cubeapp.cubeapp.core.service

import com.cubeapp.cubeapp.CubeAppApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertNotNull

@ContextConfiguration(classes = CubeAppApplication.class)
@WebAppConfiguration
@SpringBootTest
//@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class HealthTipsServiceImplTest extends Specification {
//    private HealthTipsService service;
//
//    void setup() {
//        service = new HealthTipsServiceImpl();
//    }
//
//    // GET ALL users
//    def "when get all health tips is performed, then the response has status 200 and all health tips will be returned"() {
//        when: "A list of users is required"
//        var healthTipsDto = service.getHealthTips();
//
//        then: "A list of health tips will be returned"
//        assertNotNull(healthTipsDto)
//    }
}
