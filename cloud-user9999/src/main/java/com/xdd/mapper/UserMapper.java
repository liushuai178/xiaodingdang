package com.xdd.mapper;

import com.xld.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserMapper {

    User getMyInfo(Integer id);

    void updateAll(User user);

    void updateAvatar(@Param("avatar") String avatar, @Param("id") Integer id);

    void updateNickname(@Param("nickname") String nickname, @Param("id") Integer id);

    void updateSex(@Param("sex") Integer sex, @Param("id") Integer id);

    void updateBirthday(@Param("birthday") Date birthday, @Param("id") Integer id);
}
