package com.stdioh321.sboot.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public abstract class BasicEntity {

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date deletedAt;


    public BasicEntity updateOnlyNotNull(BasicEntity entity, String[] fieldsToIgnore) {
        if (!getClass().equals(entity.getClass())) {
            return null;
        }
        try {
            for (Field f : getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Arrays.stream(fieldsToIgnore).anyMatch(s -> f.getName().equals(s))) break;
                /*if(Arrays.stream(f.getAnnotations()).anyMatch(annotation -> annotation.getClass().equals(LastModifiedDate.class))) break;*/

                if (!Objects.isNull(f.get(entity))) {
                    f.set(this, f.get(entity));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return entity;
    }
    /*@PrePersist
    public void prePersist(){
        System.out.println(" @PrePersist");
        var currentDate = new Date();
        setCreatedAt(currentDate);
        setUpdatedAt(currentDate);
    }
    @PreUpdate
    public void preUpdate(){
        var currentDate = new Date();
        setUpdatedAt(currentDate);
    }*/
}
