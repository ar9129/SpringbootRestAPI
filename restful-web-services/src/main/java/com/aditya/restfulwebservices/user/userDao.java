package com.aditya.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;

@Controller
public class userDao {
     private static List<User>users = new ArrayList<>();
     private static Integer userscount = 0 ;
     static {
    	 users.add(new User(++userscount,"aditya", LocalDate.now().minusYears(25)));
    	 users.add(new User(++userscount,"manish", LocalDate.now().minusYears(26)));
    	 users.add(new User(++userscount,"ravi", LocalDate.now().minusYears(25)));
    	 
     }
     public List<User> findAll(){
    	 return users ;
     }
     public User save(User user){
    	 user.setId(++userscount);
    	  users.add(user) ;
    	return  user ;
    	  
     }
     public User findByOne(Integer Id){
    	 Predicate<? super User> predicate =  user ->  user.getId() ==Id ;
         User user = users.stream().filter(predicate).findFirst().orElse(null);
         return user ;
     }
     
     
    
}
