package com.example.userservice.service;

import com.example.userservice.Exception.UserNotFoundException;
import com.example.userservice.dao.UserRepo;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.UserEntity;
import com.example.userservice.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    private UserEntity userEntity;


    @Override
    public UserResponseModel createUser(UserDto userDto) {
      modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity=modelMapper.map(userDto,UserEntity.class);

        UserEntity userEntity2=userRepo.save(userEntity);
        logger.info("SUCCESSFULLY INSERTED USER WITH ID "+userDto.getUserId());
        return modelMapper.map(userEntity2,UserResponseModel.class);
    }

    @Override
    public Iterable<UserResponseModel> getAllUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);


        Iterable<UserEntity> userEntityIterable=userRepo.findAll();
        Iterator<UserEntity> userEntityIterator= userEntityIterable.iterator();
        List<UserResponseModel> list= new ArrayList<>();
        while (userEntityIterator.hasNext()){
            list.add(modelMapper.map(userEntityIterator.next(),UserResponseModel.class));
        }
        logger.info("SUCCESSFULLY RETRIEVED ALL THE USERS ");
        return list;
    }

    @Override
    public UserResponseModel getUserById(String id) throws UserNotFoundException {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        if(!userRepo.existsByUserId(id)){
            throw new UserNotFoundException("User not found");
        }
        UserEntity userEntity= userRepo.findByUserId(id);
        return  modelMapper.map(userEntity,UserResponseModel.class);


    }

    @Override
    public List<UserResponseModel> findByFirstNameAndLastNameOrderByLastName(String fName, String lName) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
         List<UserEntity> userEntities=userRepo.findByFirstNameAndLastNameOrderByLastName(fName,lName);
        List<UserResponseModel> userResponseModelList=new ArrayList<>();
        for(UserEntity userEntity:userEntities){
            userResponseModelList.add(modelMapper.map(userEntity,UserResponseModel.class));
        }
        return userResponseModelList;
    }

    @Override
    public Integer deleteByUserId(String id) throws UserNotFoundException {
        if(!userRepo.existsByUserId(id)){
            throw new UserNotFoundException("User not found");
        }
      return  userRepo.deleteByUserId(id);
    }

    @Override
    public UserResponseModel updateUser(UserEntity userEntity) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
     //TODO:implement the update logic
         UserEntity userEntity1 =userRepo.save(userEntity);
         return modelMapper.map(userEntity1,UserResponseModel.class);
    }
}
