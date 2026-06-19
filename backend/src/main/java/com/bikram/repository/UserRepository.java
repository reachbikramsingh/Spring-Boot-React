package com.bikram.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikram.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findUserByEmail(String email);
}
