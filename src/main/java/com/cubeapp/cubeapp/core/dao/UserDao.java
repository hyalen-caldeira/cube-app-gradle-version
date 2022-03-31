package com.cubeapp.cubeapp.core.dao;

import com.cubeapp.cubeapp.core.repository.UserRepository;
import com.cubeapp.cubeapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component("userDao_v1")
@Transactional
public class UserDao {
    @Autowired
    UserRepository repository;

    public List<UserModel> findAll() {
        return repository.findAll();
    }

    public List<UserModel> findByNameStartingWith(String name) {
        return repository.findByNameStartingWith(name);
    }

    public Optional<UserModel> findByName(String name) {
        Optional<UserModel> model = repository.findByName(name);
        return model;
    }

    public void update(UserModel model) {
        repository.save(model);
    }

//    public boolean existsByName(String name) {
//        return repository.existsByName(name);
//    }
//
//    public boolean existsByEmail(String email) {
//        return repository.existsByEmail(email);
//    }

//    public boolean existsByUsername(String username) {
//        return repository.existsByUsername(username);
//    }
//
//    public Optional<UserEntity> findByUserId(Long userId) {
//        UserModel model = getSessionFactory().getCurrentSession().get(UserModel.class, userId);
//        User.Builder builder = (new User.Builder()).withUserModel(model);
//        return Optional.ofNullable(builder == null ? null : builder.build());
//    }

//    public Optional<User> findByUsernameOrEmail(String username, String email) {
//        Optional<UserModel> model = repository.findByUsernameOrEmail(username, email);
//        User.Builder builder = (new User.Builder()).withUserModel(model.orElse(null));
//        return Optional.ofNullable(builder == null ? null : builder.build());
//    }

    public UserModel create(UserModel model) {
        model = repository.save(model);
        return model;
    }

    public Long deleteByName(String name) {
        return repository.deleteByName(name);
    }
//
//    public List<User> findAllUsers() {
//        return null;
//    }
}
