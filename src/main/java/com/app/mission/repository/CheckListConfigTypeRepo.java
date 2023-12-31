package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.CheckConfigType;

@Repository
public interface CheckListConfigTypeRepo extends JpaRepository<CheckConfigType, Long>{

}
