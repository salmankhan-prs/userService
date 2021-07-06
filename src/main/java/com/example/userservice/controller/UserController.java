package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.ui.UserRequestModel;
import com.example.userservice.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private ModelMapper modelMapper;
    private UserService userService;
    private boolean hasErrors;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<UserResponseModel>createUser(@Valid @RequestBody UserRequestModel userDetails){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        if(errors.hasErrors()){
//            System.out.println(((errors.hasErrors())));
//            hasErrors = errors.hasErrors();
//            System.out.println(hasErrors);
//        }

        UserDto userDto=modelMapper.map(userDetails,UserDto.class);
        userDto.setUserId((UUID.randomUUID().toString()));
        System.out.println("userDto = " + userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
//        System.out.println("userDto = " + userDto);
    }
}
