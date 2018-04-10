package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaoxin on 2018/3/25 .
 */
@RestController
public class HelloSpringBoot {

    @Value("${com.spring.author}")
    private String author;
    @Value("${com.spring.content}")
    private String content;

    @RequestMapping("/hello")
    public String index() {
        return "author:"+author+",content:"+content;
    }

}