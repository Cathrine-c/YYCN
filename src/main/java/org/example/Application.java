package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// 启动类
public class Application {

    //SpringBoot在idea中运行，是在taregt/class目录下

    public static void main(String[] args) {

        // 注意第一个参数是当前类的类对象
        SpringApplication.run(Application.class, args);

    }


}