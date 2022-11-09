package com.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userdept.entities.Department;


public interface DepartamentRepository extends JpaRepository<Department, Long>{

}
