package com.stdioh321.jersey.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.stdioh321.jersey.validators.IsTimestamp;
import com.sun.istack.Nullable;

@XmlRootElement
@Entity
@Table(name = "users")

public class User implements Serializable {

	@Id
    @JsonIgnore
	private String id = UUID.randomUUID().toString();

	@NotNull(message = "Name should not be empty")
	@Length(min = 1)
	private String name;
	

	
	@Column(name = "created_at")
	private Timestamp createdAt;

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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", createdAt=" + createdAt + "]";
	}

}
