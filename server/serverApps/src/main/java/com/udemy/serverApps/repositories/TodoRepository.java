package com.udemy.serverApps.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.serverApps.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	
	List<Todo> findByUsername(String username);
}
