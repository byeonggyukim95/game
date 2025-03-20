package com.kbg.game.common.annotation;

import com.kbg.game.common.annotation.constraint.EnumCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
@Target({FIELD, PARAMETER})
@Constraint(validatedBy = EnumCodeValidator.class)
public @interface EnumCodePattern {

    String message() default "{validation.invalid.code}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> enumClass();


}
