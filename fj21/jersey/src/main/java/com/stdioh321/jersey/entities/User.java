package com.stdioh321.jersey.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.stdioh321.jersey.helpers.EntityExtender;
import com.stdioh321.jersey.validators.IsTimestamp;
import com.sun.istack.Nullable;

@XmlRootElement
@Entity
@Table(name = "users")

public class User implements Serializable, EntityExtender {

	@Id
	@JsonProperty(access = Access.READ_ONLY)
	@Column(name = "id")
	@GenericGenerator(name = "id", strategy = "com.stdioh321.jersey.genericgenerator.IdUuuid")
	@GeneratedValue(generator = "id")
	private String id;

	@NotNull(message = "Name should not be empty")
	@Length(min = 1)
	private String name;

	@Column(name = "created_at")
	@JsonProperty(access = Access.READ_ONLY)

	private Timestamp createdAt;

	@PrePersist
	public void onCreateAt() {
		this.createdAt = Timestamp.from(Instant.now());
	}

//	public void update(User user) {
//
//		try {
//			for (Field f : User.class.getDeclaredFields()) {
//				boolean isNull = Objects.isNull(f.get(user));
//				if (!isNull) {
//					f.set(this, f.get(user));
//					
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//			// TODO: handle exception
//		}
//
//	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
