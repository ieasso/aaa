package com.itheima.controller;


import com.itheima.po.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户controller
 */
@Controller
@RequestMapping("user")
public class UserController {
    //定义用户service
    @Autowired
    private UserService userService;


    /**
     * 添加用户（跳转到添加页面）
     */
    @RequestMapping("add")
    public String add(){
        return "register";
    }

    /**
     * 保存用户
     */
    @RequestMapping("/doRegister")
    public String save(User user) {

        //保存用户
        userService.saveUser(user);

        return "login";
    }

    /**
     * 查找用户
     */

    @RequestMapping("doLogin")
    public String checkUser(Model model, User user, HttpSession session){
        User user1 =  userService.findUser(user);
        if(user1 !=null && !"".equals(user1)){

            session.setAttribute("user",user1);

            model.addAttribute("user",user1);

            return "success";

        }else{
            return "login";
        }
    }
    @RequestMapping("login")
    public String login(){

        return "login";
    }


    @RequestMapping("success")
    public String houtai(){
        return "success";
    }
}
