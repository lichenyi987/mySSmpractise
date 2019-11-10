package com.itdr.mapper;

import com.itdr.pojo.Users;
import com.itdr.pojo.bo.UsersRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    更新用户金额
    public int updateByUname(String uname,int money,int type){
        String sql = "UPDATE users SET cdate=now(), money=money+? WHERE uname = ?";
        if (type == 1){
            sql = "UPDATE users SET cdate=now(), money=money-? WHERE uname = ?";
        }
        int i = jdbcTemplate.update(sql, money, uname);
        return i;
    }

//    根据用户名密码查询信息
    public Users selectByUnameAndPsd(String uname,String psd){
        String sql = "select * from users where uname = ? and psd = ?";

        Users users = jdbcTemplate.queryForObject(sql, new UsersRowMapper(), uname, psd);
        return users;
    }
}
