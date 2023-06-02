package com.aditya.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_detailsss")
public class User {
		 
     @Id
     @GeneratedValue
     private Integer Id ;
     
     @Size(min =2, message="Name should have atleast 2 characters")

     private String name ;
     
     @Past
     private LocalDate birthday ;
     
     @OneToMany(mappedBy = "user")
     @JsonIgnore
     private List<Post> posts;
     
     protected User() {
    	 
     }

	public User(Integer id, String name, LocalDate birthday) {
		super();
		Id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", birthday=" + birthday + "]";
	}
     
	
     
     
     
}
