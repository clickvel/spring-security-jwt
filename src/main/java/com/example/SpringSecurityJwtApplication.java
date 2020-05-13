package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.User;
import com.example.repoistory.UserRepoistory;

@SpringBootApplication
public class SpringSecurityJwtApplication {
  
  @Autowired
   private UserRepoistory repoistory;
  
  @PostConstruct
  public void initUsers()
  {
    List<User>users= (List<User>) Stream.of(
              
                      new User(101,"Sant","Sant","sant@gmail.com"),
                      new User(102,"Abc","Abc","abc@gmail.com")
                      ).collect(Collectors.toList()); 
    
    repoistory.saveAll(users);
  }
  

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
