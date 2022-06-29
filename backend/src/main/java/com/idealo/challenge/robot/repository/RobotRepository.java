package com.idealo.challenge.robot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idealo.challenge.robot.entity.RobotEntity;

public interface RobotRepository extends JpaRepository<RobotEntity, Long>{

}
