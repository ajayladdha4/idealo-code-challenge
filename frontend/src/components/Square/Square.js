import React from 'react';
import PropTypes from 'prop-types';

const Square = props => (
	<button className={props.direction+" square"}>
		{props.value}
	</button>
);

const SquarePropTypes = {
	direction: PropTypes.string,
	value: PropTypes.string.isRequired
};

Square.propTypes = SquarePropTypes;

export default Square;
