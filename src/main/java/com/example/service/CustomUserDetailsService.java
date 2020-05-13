package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.repoistory.UserRepoistory; 

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepoistory repoistory;
  
  
  @Override public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
     com.example.entity.User user = repoistory.findByUserName(username);
    return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
  }

} 
