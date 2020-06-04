package com.sxdx.sso.resource.two.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("client2-resource").stateless(true);; //重点，设置资源id
    }

    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .antMatchers("/login/**").permitAll();
        ;
    }
}
