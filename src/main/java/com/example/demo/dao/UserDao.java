package com.example.demo.dao;

import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
/*
    //登录时信息核对
    UserBean getInfo(String name,String password);

    //根据ID查询用户信息
    UserBean selectUserById(int id);

    //插入新的用户
    int insertUser(UserBean userBean);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(UserBean userBean);

    //查询所有用户
    List<UserBean> getAllUser();
*/

    /*以下为3.25新加入的代码，测试
     */

    //用户登录  以下三个语句曾因为“username”出过无法注册登陆的bug -->“name”
    UserBean userlogin(@Param("name") String name,@Param("password") String password);

    //注册新用户(方式1)
    int adduser(@Param("name") String name, @Param("password") String password, @Param("role") String role);

    //注册新用户（方式2）
    int adduser1(@Param("name") String name, @Param("password") String password, @Param("role") String role);


}
