package com.teamgreen.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamgreen.userservice.enums.Active;
import com.teamgreen.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findAllByActive(Active active);

}
