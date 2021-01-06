package com.stdioh321.sboot.annotations;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})

public @interface CustomAnn {
    public String key() default "";
}
