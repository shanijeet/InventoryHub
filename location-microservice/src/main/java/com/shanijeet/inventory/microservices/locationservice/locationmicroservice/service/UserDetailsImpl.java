package com.shanijeet.inventory.microservices.locationservice.locationmicroservice.service;

import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.Role;
import com.shanijeet.inventory.microservices.locationservice.locationmicroservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {


    private static final long serialVersionUID = 6052661781049261640L;

    private  User user;
    public UserDetailsImpl(User user) {

        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();

        Set<Role> roleSet=user.getRoleList();

        for(Role roles:roleSet) {

            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
