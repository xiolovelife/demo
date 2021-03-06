package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoxin on 2018/3/26 .
 */

@Controller
public class HelloIndex {
    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("title", "Hello,SpringBoot,Index");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
