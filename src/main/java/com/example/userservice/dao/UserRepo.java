package com.example.userservice.dao;

import com.example.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
 UserEntity findByUserId(String id);
 Boolean existsByUserId(String userId);
 List<UserEntity> findByFirstNameAndLastNameOrderByLastName(String fName, String lName);
 Integer deleteByUserId(String id);

}
