package com.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdept.entities.User;
import com.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	
	@PutMapping(value = "/{id}")
	public Optional<Object> putById(@RequestBody User user, @PathVariable Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(user.getName());
			employee.setEmail(user.getEmail());
			employee.setDepartment(user.getDepartment());
	        return repository.save(employee);
		});

	}

	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}

	@DeleteMapping(value = "/{id}")
	public List<User> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		List<User> result = repository.findAll();
		return result;
	}

}
