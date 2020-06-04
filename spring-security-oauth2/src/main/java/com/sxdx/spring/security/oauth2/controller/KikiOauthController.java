package com.sxdx.spring.security.oauth2.controller;

import com.sxdx.spring.security.oauth2.entity.KikiResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class KikiOauthController {
    @GetMapping(value = "/getCode")
    public KikiResponse getCode(HttpServletRequest request, HttpServletResponse response){
        return new KikiResponse()
                .put("code",request.getParameter("code"))
                .put("state",request.getParameter("state"));
    }

    @GetMapping("/authentication")
    public Object authentication(Authentication authentication){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authentication;
    }

    @GetMapping("/read")
    public String read(Authentication authentication){
        return "read";
    }

    @GetMapping("/write")
    public String write(Authentication authentication){
        return "write";
    }
}
