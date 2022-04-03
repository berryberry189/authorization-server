package com.grace.authorizationserver.init;

import com.grace.authorizationserver.domain.user.User;
import com.grace.authorizationserver.domain.user.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * H2 초기계정 세팅
 */
@Component
public class DataInit implements ApplicationRunner {

    @Resource(name="UserRepository")
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User newUser = new User();
        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        newUser.setUsername("grace");
        newUser.setPassword(passwordEncoder.encode("password"));
        newUser.setUserType(0);
        newUser.setDate(new Date());
        userRepository.save(newUser);
    }
}
