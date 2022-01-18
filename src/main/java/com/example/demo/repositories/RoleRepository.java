package com.example.demo.repositories;

import com.example.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
