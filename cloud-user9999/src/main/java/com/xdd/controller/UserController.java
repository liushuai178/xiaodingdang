package com.xdd.controller;

import com.xdd.service.UserService;
import com.xld.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("myInfo/{id}")//通过 id 查数据库，显示该用户所有信息
    public User myInfo(@PathVariable("id") Integer id) {
        return userService.getMyInfo(id);
    }

    @RequestMapping("test")
    public String test() {
        return "This is a test";
    }

}
