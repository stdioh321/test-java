package com.stdioh321.mvc.entities;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	
	
	@JsonProperty(access = Access.READ_ONLY)
	private String id;
	
	
	
	@NotNull
	@NotEmpty
	@Column(name = "fullname", nullable = false)
	private String name;
	
	@NotEmpty
	@NotNull
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	
	
	public User() {
		this.setName("Random Name");
	}

	@PrePersist
	public void onCreated() {
		Instant now = Instant.now();
		this.setCreatedAt(Timestamp.from(now));
		this.setUpdatedAt(Timestamp.from(now));
	}
	@PreUpdate
	public void onUpdated() {
		this.setUpdatedAt(Timestamp.from(Instant.now()));
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
