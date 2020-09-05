package com.xdd.service.impl;

import com.xdd.mapper.UserMapper;
import com.xdd.service.UserService;
import com.xld.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getMyInfo(Integer id) {
        return userMapper.getMyInfo(id);
    }
}
