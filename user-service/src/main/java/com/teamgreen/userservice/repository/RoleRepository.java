package com.teamgreen.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamgreen.userservice.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Modifying
	@Query("UPDATE Role r SET r.isActive = 0 WHERE r.roleId = :id")
	void delete(@Param("id") Long id);

	@Query("SELECT r FROM Role r WHERE r.isActive = :isActive ORDER BY r.roleId DESC")
	List<Role> findAllByIsActive(@Param("isActive") Integer isActive);

	@Query("SELECT r FROM Role r WHERE r.isActive = 1 AND r.roleId = :id ORDER BY r.roleId ASC")
	Optional<Role> findById(@Param("id") Long id);

}