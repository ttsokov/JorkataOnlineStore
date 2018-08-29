package org.georgi.shop.validators;

public interface ValidatorPatterns {
    public static final String VALID_EMAIL_PATTERN =
            "^([_A-Za-z0-9-+]+@[_A-Za-z0-9+-]+[_A-Za-z0-9])(.[A-Za-z]{2,})$";

    public static final String VALID_PHONE_PATTERN =
            "^(\\+3598[789]\\d{7})|(08[789]\\d{7})$";
}
