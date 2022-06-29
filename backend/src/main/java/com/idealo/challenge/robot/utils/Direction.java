package com.idealo.challenge.robot.utils;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public enum Direction {
	
	NORTH, SOUTH, EAST, WEST;

    
    public Direction left() {
        return LEFT_VALUES.get(this);
    }

    
    public Direction right() {
        return RIGHT_VALUES.get(this);
    }
    
    public Direction turnaround() {
        return TURNAROUND_VALUES.get(this);
    }
    
	public static Direction getDirection(String rawVal) {
    	switch (rawVal) {
			case "WEST":
				return WEST;
			case "EAST":
				return EAST;	
			case "SOUTH":
				return SOUTH;
			case "NORTH":
				return NORTH;
			default:
				return null;
		}
    }

    // left direction from current position
    private static final Map<Direction, Direction> LEFT_VALUES = ImmutableMap.<Direction, Direction>builder()
            .put(NORTH, WEST)
            .put(EAST, NORTH)
            .put(SOUTH, EAST)
            .put(WEST, SOUTH)
            .build();

    // right direction from current position
    private static final Map<Direction, Direction> RIGHT_VALUES = ImmutableMap.<Direction, Direction>builder()
            .put(NORTH, EAST)
            .put(EAST, SOUTH)
            .put(SOUTH, WEST)
            .put(WEST, NORTH)
            .build();
    
 // right direction from current position
    private static final Map<Direction, Direction> TURNAROUND_VALUES = ImmutableMap.<Direction, Direction>builder()
            .put(NORTH, SOUTH)
            .put(EAST, WEST)
            .put(SOUTH, NORTH)
            .put(WEST, EAST)
            .build();
}
