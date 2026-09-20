package com.example.ecommerce.repository;

import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByAge(Integer age);

}
