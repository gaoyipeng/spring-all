package com.sxdx.sso.resource.two.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TwoController {

    //@PreAuthorize("#oauth2.hasScope('write1')")
    @GetMapping("/index")
    public Map<String,String> index(){
        Map<String,String> mp = new HashMap<>();
        mp.put("key","/two/index");
        return mp;
    }

    @GetMapping(value = "/getCode")
    public String getCode(HttpServletRequest request, HttpServletResponse response){
        return request.getParameter("code");
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
