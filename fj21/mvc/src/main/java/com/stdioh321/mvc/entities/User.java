package com.stdioh321.mvc.entities;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



public class User {
	private String id;
	private String name;
	private String username;
	private String password;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public User() {
		this.setName("Random Name");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
