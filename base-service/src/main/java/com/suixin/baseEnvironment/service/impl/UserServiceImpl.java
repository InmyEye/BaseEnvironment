package com.suixin.baseEnvironment.service.impl;

import com.suixin.baseEnvironment.dao.UserMapper;
import com.suixin.baseEnvironment.domain.dataObject.User;
import com.suixin.baseEnvironment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void inserUser(User user) {
       userMapper.insert(user);
    }
}
