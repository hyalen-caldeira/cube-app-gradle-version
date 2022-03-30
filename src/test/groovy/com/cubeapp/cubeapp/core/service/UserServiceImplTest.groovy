package com.cubeapp.cubeapp.core.service

import com.cubeapp.cubeapp.CubeAppApplication
import com.cubeapp.cubeapp.core.NotFoundException
import com.cubeapp.cubeapp.core.dto.UserDto
import com.cubeapp.cubeapp.core.service.UserService
import com.cubeapp.cubeapp.core.service.UserServiceImpl
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.*

@ContextConfiguration(classes = CubeAppApplication.class)
@WebAppConfiguration
@SpringBootTest
//@ActiveProfiles("test")
class UserServiceImplTest extends Specification {
    private UserService service;

    void setup() {
        service = new UserServiceImpl();
    }

    // GET ALL users
    def "when get all users is performed, then the response has status 200 and all users will be returned"() {
        var userModels = service.getAllUsers();

        when: "A list of users is required"
        userModels = service.getAllUsers();

        then: "A list of users will be returned"
        assertNotNull(userModels)
    }

    // CREATE a new user and find by name
    def "when a new user is created, then the result will be 201 (created) and 200 (ok) as expected"() {
        given: "a new name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "a user is created"
        dto = service.create(dto);

        then: "the User was created and can be found"
        assertEquals(NAME, dto.getName())
    }

    // UPDATE an user and find by name
    def "When the user name is created and updated, then it will no longer be found"() {
        given: "a new user name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "a user is created"
        dto = service.create(dto);

        then: "the User is created and can be found"
        assertEquals(NAME, dto.getName())

        dto.setName("Moreira")

        when: "an update is requested"
        service.update(dto)

        then: "the User, as it was before, no longer exist"
        assertThrows(NotFoundException.class, () -> service.findByName(NAME))
    }

    // Create, DELETE and find an user by name
    def "When the user name is created and delete, then it will no longer be found"() {
        given: "a new user name"
        def NAME = "Hyalen"

        UserDto dto = getValidUserDto()

        when: "a user is created"
        dto = service.create(dto);

        then: "the User is created and can be found"
        assertEquals(NAME, dto.getName())

        when: "a delete is requested"
        service.deleteByName(NAME)

        then: "the User no longer exist"
        assertThrows(NotFoundException.class, () -> service.findByName(NAME))
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