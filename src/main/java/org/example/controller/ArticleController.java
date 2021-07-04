package org.example.controller;


import org.example.model.Article;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private List<Article> articleList;


    @GetMapping("/init")
    public Object init(HttpServletRequest request){
        Map<String,Object> data = new HashMap<>();

        //获取用户信息
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {

                data.put("user",user);
            }
        }
        data.put("articleList",articleList);
        return data;//ok=true,data={user:{},articleList:[{}]

    }



}
