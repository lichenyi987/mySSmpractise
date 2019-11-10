package com.itdr;


import com.itdr.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ATMtest {
    @Autowired
    UserController userController;


    @Test
    public void test1(){

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入用户名");
//        String uname = sc.next();
          String uname = "chenyi";
//        System.out.println("请输入密码");
//        String psd = sc.next();
          String psd = "123";
          userController.login(uname,psd);


    }
}
