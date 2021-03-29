package com.udemy.serverApps.repositories;

import com.udemy.serverApps.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
