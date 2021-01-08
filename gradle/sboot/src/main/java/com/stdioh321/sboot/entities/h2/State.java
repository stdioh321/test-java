package com.stdioh321.sboot.entities.h2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stdioh321.sboot.entities.BasicEntity;
import com.stdioh321.sboot.utils.EntityExt;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "state")
@EntityListeners(AuditingEntityListener.class)
@Data
/*@Where(clause = "deleted_at is NULL")*/
public class State extends BasicEntity{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    /*@JsonProperty(access = JsonProperty.Access.READ_ONLY)*/
    private String id;



    @NotNull
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Should not be Blank")
    private String name;

    @NotNull
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Should not be Blank")
    @Length(min = 2, max = 2)
    private String initial;


    /*@Column(name = "created_at", updatable = false)
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date deletedAt;*/







}
