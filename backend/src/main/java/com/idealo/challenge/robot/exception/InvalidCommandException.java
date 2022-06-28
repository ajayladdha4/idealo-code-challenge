package com.idealo.challenge.robot.exception;

import lombok.Getter;
import lombok.Setter;

public class InvalidCommandException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String command;

	public InvalidCommandException(String message, String command) {
		super(message);
		this.command = command;
	}
	
	public InvalidCommandException(String message) {
		super(message);
	}
}
