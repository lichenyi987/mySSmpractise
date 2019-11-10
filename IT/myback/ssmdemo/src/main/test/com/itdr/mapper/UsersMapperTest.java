package com.itdr.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UsersMapperTest {

    @Autowired
    UsersMapper usersMapper;


    @Test
    public void test1(){
        String uname = "chenyi";
        int money = 100;
        int type = 1;
        usersMapper.updateByUname(uname,money,type);
    }
}