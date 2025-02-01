package com.sda.travel_agency_project.security;

import com.sda.travel_agency_project.entities.AgencyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(AgencyUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }



}
