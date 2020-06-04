package com.sxdx.sso.resource.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableOAuth2Sso
@SpringBootApplication
public class SsoResourceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoResourceOneApplication.class, args);
    }


}
