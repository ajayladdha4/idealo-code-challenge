import React from 'react';
import PropTypes from 'prop-types';
import Square from '../Square/Square';
import {doMovement} from './../../services/robot.service'

class Board extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			position: props.position,
			robot: props.robot,
			maxX: props.maxX,
			maxY: props.maxY
		}
		this.executeMovementCommand = this.executeMovementCommand.bind(this);
	}

	renderSquare(value, direction, key) {
		return <Square key={key} value={value} direction={direction} />;
	}

    /**
     * Make API call to server to execute the command
     */
	async executeMovementCommand(){
		this.setState(
		  {position : await doMovement(this.props.robot.id)}
		);
	  }

	render() {
		const playerName = 'Player: '+this.state.robot.name;
		const totalX = [...Array(this.state.maxX).keys()]
		const totalY = [...Array(this.state.maxY).keys()]
		const listItems = totalX.map((link) =>
		  <div key={link} className="board-row">
			  { totalY.map((yLink) => 
				  (this.state.position.x === (link+1) && this.state.position.y === (yLink+1)) ? this.renderSquare(">", this.state.position && this.state.position.direction ? this.state.position.direction.toLowerCase(): "", yLink) : this.renderSquare(" ", undefined, yLink))}
		  </div>
		);
	
		return (
		  <div>
			<div className="status">{playerName}</div>
			{listItems}
	
	
			<button onClick={this.executeMovementCommand}>
				  Run the Script
			  </button>
		  </div>
		);
	}
}

const BoardPropTypes = {
	// always use prop types!
	position: PropTypes.object,
	robot: PropTypes.object,
	maxX: PropTypes.number,
	maxY: PropTypes.number
};

Board.propTypes = BoardPropTypes;

export default Board;
