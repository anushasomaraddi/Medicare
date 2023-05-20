package com.medicare1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
