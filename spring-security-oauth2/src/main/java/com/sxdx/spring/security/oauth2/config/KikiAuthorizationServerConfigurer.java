package com.sxdx.spring.security.oauth2.config;

import com.sxdx.spring.security.oauth2.service.KikiUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 认证服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class KikiAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private KikiUserDetailService userDetailService;
    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailService).tokenStore(tokenStore);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                    .withClient("kiki")
                    .secret(passwordEncoder.encode("123456"))
                    .authorizedGrantTypes("password", "refresh_token","authorization_code","client_credentials")
                    .autoApprove(true)
                    .scopes("all")
                    .redirectUris("http://127.0.0.1:8001/getCode","http://localhost:8001/getCode")
                    .resourceIds("kiki-resource","client1-resource","client2-resource")
                .and()
                    .withClient("client1")
                    .secret(passwordEncoder.encode("123456"))
                    .authorizedGrantTypes("authorization_code", "password","refresh_token")
                    .autoApprove(true)
                    .scopes("read")
                    .redirectUris("http://127.0.0.1:8002/one/login")
                    .resourceIds("client1-resource","client2-resource")
                .and()
                    .withClient("client2")
                    .secret(passwordEncoder.encode("123456"))
                    .authorizedGrantTypes("authorization_code","password", "refresh_token")
                    .autoApprove(true)
                    .scopes("read","write")
                    .redirectUris("http://127.0.0.1:8003/two/login")
                    .resourceIds("client2-resource")
        ;
    }
}
