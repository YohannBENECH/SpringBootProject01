package com.example.demo.userpackage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User rita = new User(
                    "Rita",
                    "R" + "1",
                    "",
                    "admin"
            );

            User rheinardt = new User(
                    "Rheinardt",
                    "R" + "2",
                    "",
                    "user"
            );

            userRepository.saveAll(
                    List.of(rita, rheinardt)
            );
        };
    }
}
