package com.sxdx.test;


import com.sxdx.redis.sentinel.RedisSentinelApplication;
import com.sxdx.redis.sentinel.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={RedisSentinelApplication.class})
public class RedisSentinelApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    public void test1() {
        System.out.println(redisService.get("s1"));
    }

    @Test
    public void test2() {
        Set<String> list=new HashSet<String>();
        list.add(null);
        list.add(null);
        list.add("asdf");
        list.add("asdf");
        System.out.println(list.size());
    }


}
