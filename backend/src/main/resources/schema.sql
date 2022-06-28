DROP TABLE IF EXISTS robot;
CREATE TABLE robot(
	id bigint auto_increment,
	code varchar(100),
	position_id bigint
);

DROP TABLE IF EXISTS position;
CREATE TABLE position(
	id bigint auto_increment,
	x int,
	y int,
	direction varchar(100)
);