package com.cubeapp.cubeapp.core.service;

import com.cubeapp.cubeapp.core.NotFoundException;
import com.cubeapp.cubeapp.core.dao.UserDao;
import com.cubeapp.cubeapp.core.dto.UserDto;
import com.cubeapp.cubeapp.core.mapper.UserMapper;
import com.cubeapp.cubeapp.model.UserModel;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Setter
    private static UserDao dao;

//    UserMapper mapper = UserMapper.INSTANCE;

    // TODO
    @Override
    public List<UserModel> getAllUsers() {
        return (List<UserModel>) dao.findAll();
    }

    @Override
    public UserDto findByName(String name) {
        var model = dao.findByName(name).orElseThrow(NotFoundException::new);

        return UserDto.builder()
                .id(model.getId())
                .name(model.getName())
                .address(model.getAddress())
                .email(model.getEmail()).build();
        // return mapper.mapModelToDto(model);
    }

    @Override
    public List<UserModel> findByNameStartingWith(String name) {
        var model = dao.findByName(name).orElseThrow(NotFoundException::new);
        return (List<UserModel>) dao.findByNameStartingWith(name);
    }

    @Override
    public void update(UserDto dto) {
        UserModel model = new UserModel();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setEmail(dto.getEmail());

        dao.update(model);
//        dao.update(mapper.mapDtoToModel(dto));
    }

    @Override
    public UserDto create(UserDto dto) {
        UserModel model = new UserModel();

        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        model.setEmail(dto.getEmail());

        UserModel userModel = dao.create(model);

        return UserDto.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .address(userModel.getAddress())
                .email(userModel.getEmail()).build();

        // return mapper.mapModelToDto(model);
    }

    @Override
    public Long deleteByName(String name) {
        return dao.deleteByName(name);
    }
}
