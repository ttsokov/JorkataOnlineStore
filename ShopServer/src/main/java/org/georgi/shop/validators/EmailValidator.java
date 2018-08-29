package org.georgi.shop.validators;

import org.georgi.shop.annotations.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return Pattern.compile(ValidatorPatterns.VALID_EMAIL_PATTERN).matcher(email).matches();
    }
}
