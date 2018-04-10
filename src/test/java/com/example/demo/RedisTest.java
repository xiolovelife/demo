package com.example.demo;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaoxin on 2018/3/27 .
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate redisTemplate;

    /*
    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    */

    @Test
    public void redisTest() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "你好啊");
        System.out.println("aaa ---> "+stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }



    @Test
    public void redisObjTest() throws Exception {

        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);

        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neox.f", user,1, TimeUnit.SECONDS);

        String name = operations.get("com.neox").getName();
       // String namef =  operations.get("com.neo.f").getName();

        System.out.println("name:"+name);
        //System.out.println("namef:"+namef);

        /*
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        */
    }
}
