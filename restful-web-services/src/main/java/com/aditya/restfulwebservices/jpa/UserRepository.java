package com.aditya.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
                  
}
