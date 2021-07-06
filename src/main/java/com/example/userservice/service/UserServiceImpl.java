package com.example.userservice.service;

import com.example.userservice.dao.UserRepo;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.UserEntity;
import com.example.userservice.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserResponseModel createUser(UserDto userDto) {
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);
        UserEntity userEntity2=userRepo.save(userEntity);
        return modelMapper.map(userEntity2,UserResponseModel.class);
    }

    @Override
    public Iterable<UserResponseModel> getAllusers() {
        return null;
    }
}
