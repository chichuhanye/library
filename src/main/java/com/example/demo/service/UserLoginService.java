package com.example.demo.service;

import com.example.demo.bean.UserBean;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLoginService {

    /**
     * 注入dao
     */
    @Autowired
    private UserDao userdao;

    //用户登录
    public UserBean userLogin(String name,String password){
        UserBean userbean = userdao.userlogin(name,password);
        return userbean;
    }

    //注册新用户
    public int adduser(String name,String password,String role){


        return userdao.adduser(name,password,role);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }
}
