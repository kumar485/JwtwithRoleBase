package com.oded.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.oded.model.Roles;
import com.oded.model.Users;

public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetails {
	    private Users user;
     
	    public MyUserDetailsService(Users user) {
			// TODO Auto-generated constructor stub
		}
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Set<Roles> roles = user.getRoles();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	         
	        for (Roles role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        System.err.println("auth"+authorities.toString()); 
	        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
