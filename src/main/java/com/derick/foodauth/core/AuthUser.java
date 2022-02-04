package com.derick.foodauth.core;

import com.derick.foodauth.domain.Client;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {

    private String fullName;
    private Long userId;

    public AuthUser(Client client, Collection<? extends GrantedAuthority> authorities) {
        super(client.getEmail(), client.getPassword(), authorities);
        this.fullName = client.getName();
        this.userId = client.getId();
    }
}
