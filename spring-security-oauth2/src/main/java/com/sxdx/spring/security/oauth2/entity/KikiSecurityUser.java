package com.sxdx.spring.security.oauth2.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.io.Serializable;
import java.util.Set;

@Data
public class KikiSecurityUser implements Serializable {

    private static final long serialVersionUID = 3191927289420949930L;
    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
