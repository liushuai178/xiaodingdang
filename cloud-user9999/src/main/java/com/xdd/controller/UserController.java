package com.xdd.controller;

import com.xdd.service.UserService;
import com.xld.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //restful风格的地址
    @GetMapping("myInfo/{id}")//通过 id 查数据库，显示该用户所有信息
    public User myInfo(@PathVariable("id") Integer id) {
        return userService.getMyInfo(id);
    }




    //测试!!!
    @PostMapping("test1")
    public void test1(@RequestBody User user) {
        System.out.println(user.getTel());
    }
    @PostMapping("test2")
    public void test2(String str) {
        System.out.println(str);
    }



    //非restful风格的地址
    @PostMapping("updateAll")//修改全部信息
    public void updateAll(@RequestBody User user) {
        userService.updateAll(user);
    }

    @PostMapping("updateAvatar")//修改头像
    public void updateAvatar(@RequestParam("avatar") String avatar, @RequestParam("id") Integer id) {
        userService.updateAvatar(avatar, id);
    }

    @PostMapping("updateNickname")//修改昵称
    public void updateNickname(@RequestParam("nickname") String nickname, @RequestParam("id") Integer id) {
        userService.updateNickname(nickname, id);
    }

    @PostMapping("updateSex")//修改性别
    public void updateAvatar(@RequestParam("sex") Integer sex, @RequestParam("id") Integer id) {
        userService.updateSex(sex, id);
    }

    @PostMapping("updateBirthday")//修改生日
    public void updateBirthday(@RequestParam("birthday") Date birthday, @RequestParam("id") Integer id) {
        userService.updateBirthday(birthday, id);
    }



}
