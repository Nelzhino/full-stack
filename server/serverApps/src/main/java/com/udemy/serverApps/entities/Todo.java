package com.udemy.serverApps.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String description;
	private Boolean isDone;
	private Date targetDate;

	public Todo() {
		super();
	}

	public Todo(Long id, String username, String description, Boolean isDone, Date targetDate) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isDone() {
		return isDone;
	}

	public void setDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
}
