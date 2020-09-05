package com.xdd.service;

import com.xld.pojo.User;

import java.util.Date;

public interface UserService {

    User getMyInfo(Integer id);

    void updateAll(User user);

    void updateAvatar(String avatar, Integer id);
    void updateNickname(String nickname, Integer id);
    void updateSex(Integer sex, Integer id);
    void updateBirthday(Date birthday, Integer id);
}
