package com.idealo.challenge.robot.service;

import com.idealo.challenge.robot.rest.dto.RobotPosition;

public interface RobotService {
	
	public RobotPosition executeMovementScript(String robotId, String script);
	
}
