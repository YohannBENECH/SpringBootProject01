package com.example.demo.userpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // GET ALL ------------------------------------------------------------------------------------
    public List<User> getUsers(){

        return userRepository.findAll();
    }

    // GET BY ID ------------------------------------------------------------------------------------
    public Optional<User> getUserById(Integer userId) {

        Optional<User> userOptional = userRepository.findById(userId);

        if(!userOptional.isPresent()) {
            throw new IllegalThreadStateException("User " + userId + " doesn't exist.");
        }

        return userOptional;
    }

    // GET BY LOGIN ------------------------------------------------------------------------------------
    public Optional<User> getUserByLogin(String userLogin) {
        Optional<User> userOptional = userRepository.findByLogin(userLogin);

        if(!userOptional.isPresent()) {
            throw new IllegalThreadStateException("User " + userLogin + " doesn't exist.");
        }

        return userOptional;
    }

    // GET BY ROLE ------------------------------------------------------------------------------------
    public Optional<User> getUserByRole(String userRole) {
        Optional<User> userOptional = userRepository.findByRole(userRole);

        if(!userOptional.isPresent()) {
            throw new IllegalThreadStateException("User " + userRole + " doesn't exist.");
        }

        return userOptional;
    }

    // REGISTER ------------------------------------------------------------------------------------
    public void registerNewUser(User user) {

        Optional<User> userOptional = userRepository.findByLogin(user.getLogin());

        if(userOptional.isPresent())
        {
            throw new IllegalMonitorStateException("Login already Exists");
        }

        userRepository.save(user); // Save user to repository
        //System.out.println(user);
    }

    // DELETE USER ------------------------------------------------------------------------------------
    public void deleteUser(Integer userId) {

        boolean exists = userRepository.existsById(userId);

        if(!exists)
        {
            throw new IllegalThreadStateException("User " + userId + " doesn't exist.");
        }
        userRepository.deleteById(userId);
    }

    // UPDATE USER ------------------------------------------------------------------------------------
    @Transactional
    public void updateUser(Integer userId, String login, String password, String name) {
        // Check if user exists, if yes get it
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("User " + userId + " doesn't exist.")
        );

        // login
        if(login != user.login
            && !login.isEmpty()
            && login.length() > 0
        ) {
            user.setLogin(login);
        }

        // password
        if(password != user.password
                && !password.isEmpty()
                && password.length() > 0
        ) {
            user.setName(password);
        }

        // name
        if(name != user.name
                && !name.isEmpty()
                && name.length() > 0
        ) {
            user.setName(name);
        }

    }


}
