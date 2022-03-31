package com.cubeapp.cubeapp.core.web

import com.cubeapp.cubeapp.core.dto.UserDto
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@Title("UserController Specification")
@Narrative("The Specification of the behaviour of the UserController. It can create a user, change the name and reset it to 'world'")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class UserControllerTest extends Specification {
    private final String BASE_URI = "/api/users/";

    @Autowired
    private MockMvc mvc

    @Autowired
    protected ObjectMapper objectMapper;

    // GET ALL users
    def "when get all users is performed, then the response has status 200 and all users will be returned"() {
        expect: "Status is 200"
        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk())
    }

    // CREATE a new user and find by name
    def "when a new user is created, then the result will be 201 (created) and 200 (ok) as expected"() {
        given: "a new name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "a user is created"
        mvc.perform(post(BASE_URI)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(UserDto.MEDIA_TYPE))
                .andExpect(status().isCreated());

        then: "the User is created"
            mvc.perform(get(BASE_URI + NAME)).andExpect(status().isOk())
        and:
            mvc.perform(get(BASE_URI + "/findByName/" + NAME)).andExpect(status().isOk())
    }

    // UPDATE an user and find by name
    def "When the user name is created and updated, then it will no longer be found"() {
        given: "a new user name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "an user is created"
        mvc.perform(post(BASE_URI)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(UserDto.MEDIA_TYPE))
                .andExpect(status().isCreated());

        then: "the User can be found"
        mvc.perform(get(BASE_URI + NAME)).andExpect(status().isOk())

        dto.setName("Moreira")

        when: "an update is requested"
        mvc.perform(put(BASE_URI + NAME)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(UserDto.MEDIA_TYPE))
                .andExpect(status().isOk());

        then: "the User, as it was before, no longer exist"
        mvc.perform(get(BASE_URI + NAME)).andExpect(status().isNotFound())
    }

    // Create, DELETE and find an user by name
    def "When the user name is created and delete, then it will no longer be found"() {
        given: "a new user name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "a user is created"
        mvc.perform(post(BASE_URI)
                .content(objectMapper.writeValueAsString(dto))
                .contentType(UserDto.MEDIA_TYPE))
                .andExpect(status().isCreated());

        then: "the User created will be returned"
        mvc.perform(get(BASE_URI + NAME)).andExpect(status().isOk())

        when: "a delete is requested"
        mvc.perform(delete(BASE_URI + NAME)).andExpect(status().isOk())

        then: "the User no longer exist"
        mvc.perform(get(BASE_URI + NAME)).andExpect(status().isNotFound())
    }

    private UserDto getValidUserDto() {
        return UserDto.builder()
                .id(1)
                .name("Hyalen")
                .address("Columbus")
                .email("hyalen@example.com")
                .build();
    }
}