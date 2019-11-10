package com.itdr.service;

import com.itdr.mapper.UsersMapper;
import com.itdr.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.beans.Transient;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

//    用户登录
    @Override
    public Users login(String uname, String psd) {
        Users u = null;

//        参数非空
        if(StringUtils.isEmpty(uname)){
            return u;
        }
        if(StringUtils.isEmpty(psd)){
            return u;
        }
//      成功返回数据
        u =  usersMapper.selectByUnameAndPsd(uname,psd);
        return u;
    }


//    用户存钱
    @Override
    public int setMoney(String uname, int money) {
//        参数验证
        if(money <= 0){
            return 0;
        }
        int i = usersMapper.updateByUname(uname,money,0);
        return i;
    }


//    用户取钱
    @Override
    public int getMoney(String uname, int money) {
//        参数验证
        if(money <= 0){
            return 0;
        }
        int i = usersMapper.updateByUname(uname,money,0);
        return i;
    }


//    用户转账
    @Override
    public int aToB(String aname, String bname, int money) {
//        参数验证
        if(money <= 0){
            return 0;
        }

//        A扣款
        int i = usersMapper.updateByUname(aname,money,1);

//        B价款
        int i2 = usersMapper.updateByUname(bname,money,0);

        return i+i2;
    }
}
