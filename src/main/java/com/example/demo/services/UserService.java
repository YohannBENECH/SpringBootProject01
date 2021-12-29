package com.example.demo.services;

import com.example.demo.objects.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUser(){
        return List.of(
                new User(
                        1,
                        "Rita",
                        "R" + "1",
                        ""
                )
        );
    }
}
