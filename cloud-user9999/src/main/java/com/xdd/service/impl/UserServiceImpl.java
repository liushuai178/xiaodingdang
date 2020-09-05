package com.xdd.service.impl;

import com.xdd.mapper.UserMapper;
import com.xdd.service.UserService;
import com.xld.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getMyInfo(Integer id) {
        return userMapper.getMyInfo(id);
    }

    @Override
    public void updateAll(User user) {
        userMapper.updateAll(user);
    }

    @Override
    public void updateAvatar(String avatar, Integer id) {
        userMapper.updateAvatar(avatar, id);
    }

    @Override
    public void updateNickname(String nickname, Integer id) {
        userMapper.updateNickname(nickname, id);
    }

    @Override
    public void updateSex(Integer sex, Integer id) {
        userMapper.updateSex(sex, id);
    }

    @Override
    public void updateBirthday(Date birthday, Integer id) {
        userMapper.updateBirthday(birthday, id);
    }
}
