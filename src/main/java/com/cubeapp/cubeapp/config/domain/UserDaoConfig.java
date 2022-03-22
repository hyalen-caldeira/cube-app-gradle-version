package com.cubeapp.cubeapp.config.domain;

import com.cubeapp.cubeapp.core.dao.UserDao;
import com.cubeapp.cubeapp.core.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserDaoConfig {
    @Autowired
    @Qualifier("userDao_v1")
    private UserDao companyDao_v1;

    @PostConstruct
    void injectDependencies() {
        UserServiceImpl.setDao(companyDao_v1);
    }
}