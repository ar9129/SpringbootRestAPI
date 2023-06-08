package com.aditya.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.* ;
import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

// console
@RestController
public class UserResource {
	  private List<User> users;
	private  userDao userdao  ;
	

	public UserResource(userDao userdao) {
	super();
	this.userdao = userdao;
}

	@GetMapping(path= "/users")
       public List<User> retrieveAllusers(){
	//	  userDao userdao = new userDao() ;
		  List<User> userlist = userdao.findAll() ;
		return userlist ;
	  }
	
	@GetMapping(path = "/users/{id}" )
	public EntityModel<User> showuser(@PathVariable Integer id) {
//		userDao userdao = new userDao() ;
		User userb =  userdao.findByOne(id) ; 
		
		if(userb ==null) {
			throw new UserNotFoundException("id:"+id);
		}
		EntityModel<User>entityModel = EntityModel.of(userb);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllusers()) ;
		entityModel.add(link.withRel("all-users"));
		return entityModel ;
	}
	
	@PostMapping(path= "/users")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		User savedUser = userdao.save(user);
		//users/4 => users/{id} => user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location ).build();
	}
}
