package com.stdioh321.sboot.entities.mysql;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.stdioh321.sboot.utils.EntityExt;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "city")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)

public class City implements EntityExt<City> {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    /*@JsonProperty(access = JsonProperty.Access.READ_ONLY)*/
    private String id;

    @NotNull
    @Column(nullable = false, unique = true)
    @NotBlank
    @Pattern(regexp = "^\\D+$",message = "Should only contain letters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_state",nullable = false)

    private State state;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
