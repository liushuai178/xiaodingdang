package com.xdd.mapper;

import com.xld.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getMyInfo(Integer id);

}
