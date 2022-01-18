package com.example.demo.services;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
