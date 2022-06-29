package com.idealo.challenge.robot.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.idealo.challenge.robot.exception.InvalidCommandException;
import com.idealo.challenge.robot.rest.dto.ErrorDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { InvalidCommandException.class })
	protected ResponseEntity<Object> handleConflict(InvalidCommandException ex, WebRequest request) {
		log.error("Error in Validations",ex);
		return handleExceptionInternal(ex,  ErrorDto.builder().message(ex.getMessage()).additionalInfo(ex.getCommand()).build(), new HttpHeaders(),
				HttpStatus.NOT_ACCEPTABLE, request);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(IllegalStateException ex, WebRequest request) {
		log.error("Error in Validations",ex);
		return handleExceptionInternal(ex, ErrorDto.builder().message(ex.getMessage()).build(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		log.error("Something went wrong",ex);
		return handleExceptionInternal(ex, ErrorDto.builder().message("Something went wrong").build(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE,
				request);
	}
}
