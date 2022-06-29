package com.idealo.challenge.robot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.idealo.challenge.robot.config.Constant;
import com.idealo.challenge.robot.exception.InvalidCommandException;
import com.idealo.challenge.robot.utils.Direction;

import lombok.Builder;
import lombok.Data;

/**
 * Class representing the position of the robot
 */
@Data
@Entity
@Table(name = "position")
@Builder
public class PositionEntity {

	@Column(name = "x")
	private int x;

	@Column(name = "y")
	private int y;

	@Column(name = "direction")
	private Direction direction;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*Takes steps and move Robot*/
	protected void move(int steps) {
		int toBeX, toBeY;
		switch (direction) {
		case SOUTH:
			toBeX = x;
			toBeY = y - steps;
			break;
		case NORTH:
			toBeX = x;
			toBeY = y + steps;
			break;
		case WEST:
			toBeX = x - steps;
			toBeY = y;
			break;
		case EAST:
			toBeX = x + steps;
			toBeY = y;
			break;
		default:
			throw new InvalidCommandException("Unable to move unknown direction " + direction.name());

		}
		if (toBeX < 1 || toBeX > Constant.maxX || toBeY < 1 || toBeX > Constant.maxY) {
			throw new InvalidCommandException(
					"Unable to move because steps are going out of board " + direction.name());
		}
		this.x = toBeX;
		this.y = toBeY;
	}

	protected void left() {
		this.direction = direction.left();
	}

	protected void right() {
		this.direction = direction.right();
	}

	protected void turnaround() {
		this.direction = direction.turnaround();
	}

	/**
	 * Default position is x=1, y=1, East facing
	 * 
	 * @return
	 */
	public static final PositionEntity defaultPosition() {
		return PositionEntity.builder().x(1).y(1).direction(Direction.EAST).build();
	}
}
