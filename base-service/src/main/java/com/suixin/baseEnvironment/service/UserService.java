package com.suixin.baseEnvironment.service;

import com.suixin.baseEnvironment.domain.dataObject.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public void inserUser(User user);
}
