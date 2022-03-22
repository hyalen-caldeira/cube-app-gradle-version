package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    List<UserModel> findByNameStartingWith(String name);
    UserDto findByName(String name);
    void update(UserDto dto);
    UserDto create(UserDto dto);
    Long deleteByName(String name);
}
