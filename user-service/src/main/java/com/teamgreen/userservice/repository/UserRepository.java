package com.teamgreen.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamgreen.userservice.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	@Modifying
	@Query("UPDATE User u SET u.isActive = 0 WHERE u.userId = :id")
	void delete(@Param("id") Long id);

	@Query("SELECT u FROM User u WHERE u.isActive = :isActive ORDER BY u.userId DESC")
	List<User> findAllByIsActive(Integer isActive);
	
	@Query("SELECT u FROM User u WHERE u.isActive = 1 AND u.userId = :id ORDER BY u.userId ASC")
	Optional<User> findById(@Param("id") Long id);

}