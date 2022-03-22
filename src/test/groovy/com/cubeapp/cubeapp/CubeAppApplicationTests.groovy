package com.cubeapp.cubeapp;

import com.cubeapp.cubeapp.core.web.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Narrative;
import spock.lang.Specification;
import spock.lang.Title;

@Title("Application Specification")
@Narrative("Specification which beans are expected")
@SpringBootTest
class CubeAppApplicationTests extends Specification {

	@Test
	void contextLoads() {
	}

	@Autowired(required = false)
	private UserController userController;

	def "when context is loaded then all expected beans are created"() {
		expect: "the WebController is created"
		userController
	}

	@Test
	void main() {
		CubeAppApplication.main(new String[] {});
	}
}