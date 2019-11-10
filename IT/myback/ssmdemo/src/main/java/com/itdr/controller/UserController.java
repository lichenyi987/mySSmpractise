package com.itdr.controller;


import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;

@Controller
@RequestMapping("/portal/users")
public class UserController {


    @Autowired
    UserService userService;

//    用户登录
    @RequestMapping("login.action")
    public String login(String uname ,String psd){
        Users users = userService.login(uname, psd);
        if (users == null){
//            System.out.println(uname+"用户登录失败");
        return "用户登录失败";
        }
//        System.out.println(uname+"用户登录成功");
        return "用户登录成功";
    }
//    用户存钱
//    用户取钱
//    用户转账
}
