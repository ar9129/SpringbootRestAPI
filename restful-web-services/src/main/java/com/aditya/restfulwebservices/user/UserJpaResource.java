package com.aditya.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aditya.restfulwebservices.jpa.PostRepository;
import com.aditya.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

// console
@RestController
public class UserJpaResource {
	private List<User> users;
	private userDao userdao;
	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		super();
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllusers() {
		List<User> userlist = repository.findAll();
		return userlist;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		User savedUser = repository.save(user);
		// users/4 => users/{id} => user.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Optional<User> showuser(@PathVariable Integer id) {
		Optional<User> userb = repository.findById(id);

		if (userb.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		return userb;
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> userb = repository.findById(id);

		if (userb.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		return userb.get().getPosts();
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> userb = repository.findById(id);

		if (userb.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		post.setUser(userb.get());
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
