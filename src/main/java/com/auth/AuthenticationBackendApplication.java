package com.auth;

import com.auth.models.ApplicationUser;
import com.auth.models.Role;
import com.auth.repository.RoleRepository;
import com.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticationBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthenticationBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
          if (roleRepository.findByAuthority("ADMIN").isPresent() ||roleRepository.findByAuthority("USER").isPresent()  ) return;

            Role adminRole = roleRepository.save(new Role("ADMIN"));
            Role userRole = roleRepository.save(new Role("USER"));
            Set<Role> roles = new HashSet<>();
            Set<Role> roles1 = new HashSet<>();
            roles.add(adminRole);
            roles1.add(userRole);
            ApplicationUser admin = new ApplicationUser(1, "admin", passwordEncoder.encode("password"), roles);
            ApplicationUser user = new ApplicationUser(2, "user", passwordEncoder.encode("password"), roles1);
            userRepository.save(admin);
            userRepository.save(user);

        };
    }

}
