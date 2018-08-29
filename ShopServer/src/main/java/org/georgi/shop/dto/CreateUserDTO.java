package org.georgi.shop.dto;

import org.georgi.shop.annotations.ValidEmail;
import org.georgi.shop.annotations.ValidPhone;

import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateUserDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @ValidEmail
    @NotEmpty
    private String email;

    @ValidPhone
    @NotEmpty
    private String phone;

    @Min(18)
    @Digits(integer = 2, fraction = 0)
    private int age;

    @NotEmpty
    @Size(min = 6, max = 24)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
