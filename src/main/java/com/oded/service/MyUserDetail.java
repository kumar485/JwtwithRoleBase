package com.oded.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oded.model.Roles;
import com.oded.model.Users;
import com.oded.repo.RolesRepo;
import com.oded.repo.UserRepo;
@Service
public class MyUserDetail implements UserDetailsService{
	@Autowired
	private UserRepo urepo;
//	@Autowired
//	private RolesRepo rrepo;
	Users duser=null;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.err.println("------------------------------------------------");
		   
		 duser = urepo.findByUserName(username);
		 System.err.println(duser);
		 
		  return new User(duser.getUsername(),duser.getPassword(),getAuthorities());
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles = duser.getRoles();
        //System.err.println(roles);
        List<SimpleGrantedAuthority> authorities = new ArrayList();
         
        for (Roles role : roles) {
        	System.err.println("role"+role.getName());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
         System.err.println("auth"+authorities);
        return authorities;
    }
	

}
