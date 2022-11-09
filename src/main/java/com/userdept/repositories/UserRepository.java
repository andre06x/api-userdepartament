package com.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
