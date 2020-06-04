package com.sxdx.springmvc.controller;

import com.sxdx.springmvc.entity.Outer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-all
 * @description: 内部类
 * @author: garnett
 * @create: 2020-04-01 15:43
 **/

@RestController
public class OuterAndInner {

    @Autowired
    private Outer outer;

    @GetMapping("/demo")
    public void demo(){
        outer.sayHello();
    }
}
