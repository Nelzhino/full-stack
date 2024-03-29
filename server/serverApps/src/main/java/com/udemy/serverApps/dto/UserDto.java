package com.udemy.serverApps.dto;

import java.util.List;

public class UserDto {

	private String username;
	private String password;
	private List<String> roles;
	private boolean createUser;

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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isCreateUser() {
		return createUser;
	}

	public void setCreateUser(boolean createUser) {
		this.createUser = createUser;
	}


}
