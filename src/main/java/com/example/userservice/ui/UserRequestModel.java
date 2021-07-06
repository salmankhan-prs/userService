package com.example.userservice.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {
    @NotBlank(message = "first name can not be blank")
    private String firstName;
    @NotBlank(message = "last name can not be blank")
    private String lastName;
    @Email(message = "not a valid email")
    private String email;
    @NotBlank
    private String password;
}
