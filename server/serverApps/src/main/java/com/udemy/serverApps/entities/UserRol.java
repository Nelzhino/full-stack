package com.udemy.serverApps.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_rol", uniqueConstraints = @UniqueConstraint( columnNames = {
		"rol", "username"
}))
public class UserRol {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	private User user;
	@Column(name = "rol", nullable = false)
	private String rol;

	public UserRol(Long id, User user, String rol) {
		super();
		this.id = id;
		this.user = user;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public UserRol() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
