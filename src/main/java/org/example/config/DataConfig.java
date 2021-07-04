package org.example.config;

import org.example.model.Article;
import org.example.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataConfig {


    @Bean
    public User user(){
        User user = new User();
        user.setUsername("abc");
        user.setPassword("123");
        user.setNickname("孙空");
        user.setEmail("1732000@qq.com");

        return user;

    }

    @Bean
    public List<Article> articleList(){

        List<Article> list = new ArrayList<>();

        Article a1 = new Article();
        a1.setArticleId(1);
        a1.setTitle("手动蝶阀带我飞");
        a1.setContent("举舞弄轻盈");
        list.add(a1);

        Article a2 = new Article();
        a2.setArticleId(2);
        a2.setTitle("单身宿舍");
        a2.setContent("的单色驱蚊器而且我开发及");
        list.add(a2);

        Article a3 = new Article();
        a3.setArticleId(3);
        a3.setTitle("慕课上");
        a3.setContent("开发，十一哦哦巨大市财政局");
        list.add(a3);

        return list;

    }


}
