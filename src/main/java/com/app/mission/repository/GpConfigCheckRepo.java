package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.GpConfigCheck;

@Repository
public interface GpConfigCheckRepo extends JpaRepository<GpConfigCheck, Long>{

}
