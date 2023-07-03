package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
