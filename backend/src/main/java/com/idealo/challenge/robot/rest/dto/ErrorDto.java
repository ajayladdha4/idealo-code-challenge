package com.idealo.challenge.robot.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
	private String message;
	private String additionalInfo;
}
