package com.it.simplytodo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if(phone == null) {
            return false;
        }

        String pattern = "^\\+?1?[\\s-]?\\(?[2-9]\\d{2}\\)?[\\s-]?[2-9]\\d{2}[\\s-]?\\d{4}$";
        return phone.matches(pattern);
    }
}
