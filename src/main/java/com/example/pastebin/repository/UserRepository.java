package com.example.pastebin.repository;

import com.example.pastebin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u")
    List<User> findAll();
    @Query( value = "insert into c(name) values (:name)",nativeQuery = true)
    void createUser( @Param("name") String name);
    User findUserById(Long id);

}
