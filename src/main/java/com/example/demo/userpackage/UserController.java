package com.example.demo.userpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/id/{userId}")
    public Optional<User> getUsers(@PathVariable("userId") Integer userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/login/{userLogin}")
    public Optional<User> getUsersByLogin(@PathVariable("userLogin") String userLogin){
        return userService.getUserByLogin(userLogin);
    }

    @GetMapping("/role/{userRole}")
    public Optional<User> getUsersByRole(@PathVariable("userRole") String userRole){
        return userService.getUserByRole(userRole);
    }

    @PostMapping("/register")
    public void registerNewUser(@RequestBody User user) {
        userService.registerNewUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/update/{userId}")
    public void updateUser(
        @PathVariable("userId") Integer userId,
        @RequestParam(required = false) String login,
        @RequestParam(required = false) String password,
        @RequestParam(required = false) String name) {

        userService.updateUser(userId, login, password, name);
    }
}
