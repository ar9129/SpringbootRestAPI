package com.aditya.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_detailsss")
public class User {
	
     @Size(min =2)
     @Id
     @GeneratedValue
     private Integer Id ;
     private String name ;
     
     @Past
     private LocalDate birthday ;
     
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
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", birthday=" + birthday + "]";
	}
     
	
     
     
     
}
