package com.idealo.challenge.robot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.idealo.challenge.robot.entity.PositionEntity;
import com.idealo.challenge.robot.entity.RobotEntity;
import com.idealo.challenge.robot.exception.InvalidCommandException;
import com.idealo.challenge.robot.utils.Direction;

public class RobotUnitTest {
	
	private RobotEntity robotEntity;
	
	@BeforeEach
	void setup() throws Exception {
		robotEntity = RobotEntity.builder().code("123123-qweqweq").position(PositionEntity.defaultPosition()).build();
	}
	
	
	@Test
	void commandTest_position() throws Exception {
		String command = "POSITION 1 3 EAST //sets the initial position for the robot";
		robotEntity.moveRobot(command);
		
		assertEquals(robotEntity.getPosition().getX(), 1);
		assertEquals(robotEntity.getPosition().getY(), 3);
		assertEquals(robotEntity.getPosition().getDirection(), Direction.EAST);
	}
	
	@Test
	void commandTest_forward() throws Exception {
		String command = "FORWARD 3 //lets the robot do 3 steps forward";
		robotEntity.moveRobot(command);
		
		assertEquals(robotEntity.getPosition().getX(), 4);
		assertEquals(robotEntity.getPosition().getY(), 1);
		assertEquals(robotEntity.getPosition().getDirection(), Direction.EAST);
	}


	
	@Test
	void commandTest_validationfailed() throws Exception {
		String command = "FORWARD 5 //lets the robot do 3 steps forward";
		Exception exception = assertThrows(InvalidCommandException.class, () -> {
			robotEntity.moveRobot(command);
	    });

	    String expectedMessage = "Unable to move because steps are going out of board ";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
}