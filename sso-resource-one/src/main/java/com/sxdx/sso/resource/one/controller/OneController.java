package com.sxdx.sso.resource.one.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class OneController {

    //@PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/index")
    public Map<String,String> index(){
        Map<String,String> mp = new HashMap<>();
        mp.put("key","/one/index");
        return mp;
    }

    //@PreAuthorize("hasAuthority('user:add') and #oauth2.hasScope('read')")
    @GetMapping("/user")
    public Principal user(Principal principal) {
        log.info("获取当前登录人信息");
        return principal;
    }
}
