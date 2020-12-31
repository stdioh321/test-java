package com.stdioh321.sboot.utils;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.LastModifiedDate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public interface EntityExt<T extends EntityExt> {


    default public T update(T entity, String[] fieldsToIgnore) {
        if (!getClass().equals(entity.getClass())) {
            return null;
        }
        try {
            for (Field f : getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Arrays.stream(fieldsToIgnore).anyMatch(s -> f.getName().contains(s))) break;
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

}
