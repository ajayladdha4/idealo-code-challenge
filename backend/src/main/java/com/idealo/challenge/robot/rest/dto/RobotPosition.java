package com.idealo.challenge.robot.rest.dto;

import com.idealo.challenge.robot.utils.Direction;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RobotPosition {
	
	private String id;
	private int x;
    private int y;
    private Direction direction;
    
    
}
