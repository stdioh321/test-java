package com.stdioh321.jersey.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.stdioh321.jersey.entities.User;

@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { TimestampValidator.class })
@Documented

public @interface IsTimestamp {
	String message() default "Not a timestamp";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

class TimestampValidator implements ConstraintValidator<IsTimestamp, User> {
	@Override
	public void initialize(IsTimestamp constraintAnnotation) {

	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		// call to the DB and verify that value.getEmail() is unique
		System.out.println(value.getCreatedAt());
		return false;
	}
}
