import React from 'react';
import Board from '../Board/Board';

const Game = props => (
	<div className="game">
		<div className="game-board">
			<Board position={initialPosition} robot={robot} maxX={5} maxY={5} />
		</div>
	</div>
);

let initialPosition = {
	facing: "EAST",
	x: 1,
	y: 1
}

let robot = {
	id: "qwert-trewq-1234",
	name: "Ajay's Robot",
}

// todo: Unless you need to use lifecycle methods or local state,
// write your component in functional form as above and delete
// this section. 
// class Game extends React.Component {
//   render() {
//     return <div>This is a component called Game.</div>;
//   }
// }

// const GamePropTypes = {
// 	// always use prop types!
// };

// Game.propTypes = GamePropTypes;

export default Game;
