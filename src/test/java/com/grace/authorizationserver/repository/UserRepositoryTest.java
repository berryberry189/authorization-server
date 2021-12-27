package com.grace.authorizationserver.repository;

import com.grace.authorizationserver.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;

   @Test
    public void createUser() {
        userRepository.save(User.builder()
                .uid("user")
                .password(passwordEncoder.encode("pass"))
                .name("shin")
                .email("berryberry189@naver.com")
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }
}
