package com.idealo.challenge.robot.service.impl;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.idealo.challenge.robot.entity.PositionEntity;
import com.idealo.challenge.robot.entity.RobotEntity;
import com.idealo.challenge.robot.repository.RobotRepository;
import com.idealo.challenge.robot.rest.dto.RobotPosition;
import com.idealo.challenge.robot.service.RobotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RobotServiceImpl implements RobotService {
	
	private final RobotRepository repository;
	
	@Transactional
	public RobotPosition executeMovementScript(String robotId, String script) {
		RobotEntity robot = new RobotEntity();
		robot.setCode(robotId);
		
		//Setting default position
		robot.setPosition(PositionEntity.defaultPosition());
		
		//Executing each command by move robot method
		try (Stream<String> stream = new BufferedReader(new StringReader(script))
		        .lines()) {
			stream.forEach(cmd -> robot.moveRobot(cmd));
		}
		repository.save(robot);
		return robot.toDto();
	}
	
}
