package com.example.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepoistory extends JpaRepository<User, Integer> {

  User findByUserName(String username);

}
