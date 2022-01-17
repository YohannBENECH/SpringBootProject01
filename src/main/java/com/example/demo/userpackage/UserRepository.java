package com.example.demo.userpackage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.login = ?1")
    Optional<User> findByLogin(String login);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    Optional<User> findByRole(String role);
}
