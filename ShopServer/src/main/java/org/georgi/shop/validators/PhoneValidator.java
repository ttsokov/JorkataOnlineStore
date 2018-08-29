package org.georgi.shop.validators;

import org.georgi.shop.annotations.ValidPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return Pattern.compile(ValidatorPatterns.VALID_PHONE_PATTERN).matcher(phone).matches();
    }
}
