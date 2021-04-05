package com.udemy.serverApps.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRol> roles = new HashSet<UserRol>();
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRol> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRol> roles) {
		this.roles = roles;
	}

}
