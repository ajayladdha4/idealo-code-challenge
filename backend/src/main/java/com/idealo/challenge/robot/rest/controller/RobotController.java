package com.idealo.challenge.robot.rest.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idealo.challenge.robot.rest.dto.RobotPosition;
import com.idealo.challenge.robot.service.RobotService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/robots")
@RequiredArgsConstructor
public class RobotController {
	
	private final RobotService robotService;
	
    @PostMapping(value = "{robotId}/commands", consumes = "text/plain")
    public ResponseEntity<RobotPosition> executeMovementScript(@RequestBody @NotNull @NotBlank String payload, @PathVariable("robotId") String robotId) {
        return ResponseEntity.ok(robotService.executeMovementScript(robotId, payload));
    }
}
