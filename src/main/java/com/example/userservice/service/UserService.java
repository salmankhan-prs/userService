package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.ui.UserResponseModel;

public interface UserService {

 UserResponseModel createUser(UserDto userDto);
Iterable<UserResponseModel>getAllusers();
}