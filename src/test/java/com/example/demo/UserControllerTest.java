package com.example.demo;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.mapper.UserMapper;

import java.util.List;

/**
 * Created by xiaoxin on 2018/3/26 .
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserMapper UserMapper;

    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new User("xiaoxin",12));
        UserMapper.insert(new User("xiaohong",18));
        UserMapper.insert(new User("xiaoming",15));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = UserMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = UserMapper.getOne(3l);
        System.out.println(user.toString());
        user.setName("wuyanzhu");
        UserMapper.update(user);
        Assert.assertTrue(("wuyanzhu".equals(UserMapper.getOne(3l).getName())));
    }
}
