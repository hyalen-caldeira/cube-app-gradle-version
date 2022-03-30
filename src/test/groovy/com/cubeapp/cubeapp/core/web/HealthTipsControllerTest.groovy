package com.cubeapp.cubeapp.core.web

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("HealthTipsController Specification")
@Narrative("The Specification of the behaviour of the HealthTipsController.")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class HealthTipsControllerTest extends Specification {
    @Autowired
    private MockMvc mvc

    @Autowired
    protected ObjectMapper objectMapper;

    def "when get all health tips is performed, then the response has status 200 and all health tips will be returned"() {
        expect: "Status is 200"
        mvc.perform(MockMvcRequestBuilders.get("/api/health-tips")).andExpect(MockMvcResultMatchers.status().isOk())
    }
}
