package com.idealo.challenge.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.yml")
@TestMethodOrder(OrderAnnotation.class)
public class RobotIntegerationApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	private final String robotId = "1123-qwe-123";
	
	private final String input = "POSITION 1 3 EAST //sets the initial position for the robot \n"
	+ "	FORWARD 3 //lets the robot do 3 steps forward \n"
	+ "	WAIT //lets the robot do nothing \n"
	+ "	TURNAROUND //lets the robot turn around \n"
	+ "	FORWARD 1 //lets the robot do 1 step forward \n"
	+ "	RIGHT //lets the robot turn right \n"
	+ "	FORWARD 2 //lets the robot do 2 steps forward";

	@Test
	void test_e2e() throws Exception {
		MvcResult match_result = mockMvc
				.perform(post("/robots/"+robotId+"/commands").contentType(MediaType.TEXT_PLAIN_VALUE).content(input))
//            .andDo(print())
				.andExpect(status().isOk()).andReturn(); // jsonPath("$.customerId").value("1")

		String content = match_result.getResponse().getContentAsString();

		assertEquals(content, "{\"id\":\"1123-qwe-123\",\"x\":1,\"y\":3,\"direction\":\"EAST\"}", "Checking Response");
	}

}
