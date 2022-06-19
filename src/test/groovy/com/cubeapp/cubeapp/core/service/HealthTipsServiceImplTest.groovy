package com.cubeapp.cubeapp.core.service

import com.cubeapp.cubeapp.CubeAppApplication
import com.cubeapp.cubeapp.core.dto.client.HealthTipsDto
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = CubeAppApplication.class)
@WebAppConfiguration
@SpringBootTest
//@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class HealthTipsServiceImplTest extends Specification {
    private final String HOST_PORT = "http://localhost:8081";
    private final String BASE_URI = "/api/health-tips";
    private HealthTipsDto healthTipsDto;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private HealthTipsService service = new HealthTipsServiceImpl();

    void setup() {
//        healthTipsDto = new HealthTipsDto(1, "Health tip one", 11);
//
//        when(restTemplate.exchange(
//                        HOST_PORT + BASE_URI,
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<HealthTipsDto>>() {}))
//                        .thenReturn(new ResponseEntity(Arrays.asList(healthTipsDto), HttpStatus.OK));
    }

    // GET ALL health tips
    def "when get all health tips is performed, then the response has status 200 and all health tips will be returned"() {
        given: ""
        healthTipsDto = new HealthTipsDto(1, "Health tip one", 11);

        when(restTemplate.exchange(
                HOST_PORT + BASE_URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HealthTipsDto>>() {}))
                .thenReturn(new ResponseEntity(Arrays.asList(healthTipsDto), HttpStatus.OK));

        when: "A list of health tips is required"
        var healthTipsDto = service.getHealthTips();

        then: "A list of health tips will be returned"
        assertNotNull(healthTipsDto)
    }

    // GET ALL health tips by user id
    def "when get all health tips by user id is performed, then the response has status 200 and all health tips will be returned"() {
        given: ""
        healthTipsDto = new HealthTipsDto(1, "Health tip one", 11);

        when(restTemplate.exchange(
                HOST_PORT + BASE_URI + "/1",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<HealthTipsDto>>() {}))
                .thenReturn(new ResponseEntity(Arrays.asList(healthTipsDto), HttpStatus.OK));

        when: "A list of health tips is required"
        var healthTipsDto = service.getHealthTipsByUserId(1);

        then: "A list of health tips will be returned"
        assertNotNull(healthTipsDto)
    }
}
