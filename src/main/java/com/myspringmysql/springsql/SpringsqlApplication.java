package com.myspringmysql.springsql;

import com.myspringmysql.springsql.model.Role;
import com.myspringmysql.springsql.model.UserModel;
import com.myspringmysql.springsql.repository.RoleRepository;
import com.myspringmysql.springsql.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsqlApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            if (roleRepository.findByAuthority("ADMIN").isPresent()) return;
//            Role adminRole = roleRepository.save(Role.builder().authority("ADMIN").build());
//            Set<Role> roles = new HashSet<>();
//            roles.add(adminRole);
//            UserModel userModel = UserModel.builder()
//                    .authorities(roles)
//                    .userName("Ujjwal1")
//                    .password(passwordEncoder.encode("password"))
//                    .build();
//
//            userRepository.save(userModel);
//        };
//    }
}
