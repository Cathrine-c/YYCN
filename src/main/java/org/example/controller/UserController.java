package org.example.controller;

import org.example.exception.AppException;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;


    @PostMapping("/login")
    public Object login(User user, HttpServletRequest request){

        //模拟请求账号密码，在数据库查询对比
        if (!this.user.getUsername().equals(user.getUsername())){

            throw new AppException("账号不存在");
        }
        if (!this.user.getPassword().equals(user.getPassword())){

            throw new AppException("密码错误！");

        }

        HttpSession session = request.getSession();
        session.setAttribute("user",this.user);
        return null;
    }

}
