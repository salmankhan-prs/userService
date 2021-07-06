package com.example.userservice.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;

}
