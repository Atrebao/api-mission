package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.CheckConfigType;
import com.app.mission.model.CheckListConfig;

@Repository
public interface CheckListConfigRepo extends JpaRepository<CheckListConfig, Long>{

}
