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

import com.userdept.entities.Department;
import com.userdept.repositories.DepartamentRepository;

@RestController
@RequestMapping(value = "/departament")
public class DepartmentController {

	@Autowired
	private DepartamentRepository repository;

	@GetMapping
	public List<Department> findAll() {
		List<Department> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Department findById(@PathVariable Long id) {
		Department result = repository.findById(id).get();
		return result;
	}

	@PutMapping(value = "/{id}")
	public Optional<Object> putById(@RequestBody Department departament, @PathVariable Long id) {
		return repository.findById(id).map(employee -> {
			employee.setName(departament.getName());
	        return repository.save(employee);
		});

	}

	@PostMapping
	public List<Department> insert(@RequestBody List<Department> department) {
		List<Department> result = repository.saveAll(department);
		return result;
	}

	@DeleteMapping(value = "/{id}")
	public List<Department> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		List<Department> result = repository.findAll();
		return result;
	}

}
