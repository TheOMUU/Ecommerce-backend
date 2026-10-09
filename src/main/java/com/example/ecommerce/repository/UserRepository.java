package com.example.ecommerce.repository;

import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByAge(Integer age);
    List<User> findByAgeBetween(Integer minAge, Integer maxAge);

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.age > :age")
    List<User> findByNameAndAge1(@Param("name")String name, @Param("age") int age);

    @Query("SELECT u FROM User u WHERE u.name LIKE %:nameContain% ")
    List<User> findIfNameContains(@Param("nameContain") String name);

}
