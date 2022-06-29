package com.idealo.challenge.robot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.idealo.challenge.robot.exception.InvalidCommandException;
import com.idealo.challenge.robot.rest.dto.RobotPosition;
import com.idealo.challenge.robot.utils.Direction;
import com.idealo.challenge.robot.utils.NumberUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "robot")
@NoArgsConstructor
@AllArgsConstructor
public class RobotEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code")
	private String code;

	@JoinColumn(name = "position_id")
	@OneToOne(cascade = CascadeType.ALL)
	private PositionEntity position;

	public RobotPosition toDto() {
		return RobotPosition.builder().id(code).x(this.position.getX()).y(this.position.getY())
				.direction(this.position.getDirection()).build();
	}

	/**
	 * Based on the command it will change the position of Robot
	 * 
	 * @param commandString
	 */
	public void moveRobot(final String commandString) {
		String commands[] = commandString.split(" ");
		if (commands.length == 0) {
			throw new InvalidCommandException("No Command");
		}

		switch (commands[0]) {
		case "POSITION":
			if (commands.length < 4) {
				throw new InvalidCommandException("Position arguments are not valid. It should have X, Y, Direction",
						commandString);
			}

			int x = NumberUtils.getNumber(commands[1]);
			int y = NumberUtils.getNumber(commands[2]);
			Direction direction = Direction.getDirection(commands[3]);

			if (x < 0 || y < 0 || direction == null) {
				throw new InvalidCommandException("Position arguments are not valid. X, Y, Direction are not valid",
						commandString);
			}

			this.position = PositionEntity.builder().x(x).y(y).direction(direction).build();
			break;
		case "WAIT":
			break;
		case "FORWARD":
			if (this.position == null) {
				throw new InvalidCommandException("Initial Position should be first command", commandString);
			}

			if (commands.length < 2) {
				throw new InvalidCommandException("No Command");
			}
			int move = NumberUtils.getNumber(commands[1]);
			if (move < 0) {
				throw new InvalidCommandException("Forward Sub Commands is not valid. Steps are are not valid",
						commandString);
			}
			this.position.move(move);
			break;

		case "TURNAROUND":
			if (this.position == null) {
				throw new InvalidCommandException("Initial Position should be first command", commandString);
			}

			this.position.turnaround();
			break;

		case "RIGHT":
			if (this.position == null) {
				throw new InvalidCommandException("Initial Position should be first command", commandString);
			}

			this.position.right();
			break;

		case "LEFT":
			if (this.position == null) {
				throw new InvalidCommandException("Initial Position should be first command", commandString);
			}

			this.position.left();
			break;

		default:
			break;
		}
	}
}
