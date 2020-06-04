package com.sxdx.redis.sentinel.controller;

import com.sxdx.redis.sentinel.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-all
 * @description: demo
 * @author: garnett
 * @create: 2020-03-22 15:51
 **/

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;


    @GetMapping("/test1")
    public String  test1() {
        return redisService.get("s1").toString();
    }
}
