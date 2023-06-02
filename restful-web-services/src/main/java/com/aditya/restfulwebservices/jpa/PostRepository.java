package com.aditya.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
                  
}
