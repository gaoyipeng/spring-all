package com.sxdx.springmvc.controller;

import com.sxdx.springmvc.entity.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

/**
 * @program: spring-all
 * @description: demo
 * @author: garnett
 * @create: 2020-03-15 11:05
 **/


@Controller
public class DemoController {

    @ModelAttribute
    public  Dog  testModelAttribute(){
        Dog dog = new Dog("德牧",2);
        return dog;
    }

    @RequestMapping(value = "/index")
    @ModelAttribute(value = "attribute")
    public String index() {
        return "attributeValue";
    }

    @RequestMapping(value = "/index2")
    public String index1( Model model) {
        Dog dog = new Dog();
        dog.setName("二哈2");
        dog.setAge(2);
        model.addAttribute("dog",dog);
        return "index";
    }

    @RequestMapping(value = "/index3")
    public String index2( Map map) {
        Dog dog = new Dog();
        dog.setName("二哈3");
        dog.setAge(3);
        map.put("dog",dog);

        ArrayList<String> list=new ArrayList<String>();
        list.add(null);
        list.add(null);
        return "index";
    }

}