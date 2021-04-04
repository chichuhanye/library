package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/user"})
public class UserLoginController {

    /**
     * 注入service
     */
    @Autowired
    private UserLoginService userLoginService;

    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping(value = {"/loginPage"})
    public String loginPage(){
        return "login";
    }

    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerPage"})
    public String registerPage(){
        return "register";
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request){

        UserBean userbean = userLoginService.userLogin(name,password);

        if(userbean != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",userbean);     //将用户信息放入session
            return "success";
        }
        return "error";
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/userRegister"})
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("role") String role){

        if(!password.equals(password2)){    //3.25待解决：为什么注册之后返回error.html?数据库却有数据加入？

            return "Two passwords can't match, fail to register";
        }else {
            int res = userLoginService.adduser(name,password,role);
            if(res == 0){
                return "registration failed";
            }else {
                return "registration success";
            }
        }

    }
}
