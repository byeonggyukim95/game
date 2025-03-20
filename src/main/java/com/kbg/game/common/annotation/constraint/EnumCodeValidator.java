package com.kbg.game.common.annotation.constraint;

import com.kbg.game.common.annotation.EnumCodePattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumCodeValidator implements ConstraintValidator<EnumCodePattern, String> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumCodePattern constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String var1, ConstraintValidatorContext var2) {
        if (var1.isBlank()) {
            return false;
        }

        try {
            Enum.valueOf(enumClass.asSubclass(Enum.class), var1);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
