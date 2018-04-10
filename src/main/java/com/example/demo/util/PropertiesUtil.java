package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xiaoxin on 2018/3/26 .
 */
@Component
public class PropertiesUtil {

    @Value("${com.spring.author}")
    private String author;
    @Value("${com.spring.content}")
    private String content;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
