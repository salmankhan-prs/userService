package com.example.userservice.service;

import com.example.userservice.Exception.UserNotFoundException;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.UserEntity;
import com.example.userservice.ui.UserResponseModel;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

 UserResponseModel createUser(UserDto userDto);
Iterable<UserResponseModel>getAllUsers();
UserResponseModel getUserById(String id) throws UserNotFoundException;
List<UserResponseModel> findByFirstNameAndLastNameOrderByLastName(String fName, String lName);
Integer deleteByUserId(String id) throws UserNotFoundException;
UserResponseModel updateUser(UserEntity userEntity);
}
