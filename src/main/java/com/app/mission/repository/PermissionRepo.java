package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long>{

}
