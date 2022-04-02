package com.grace.authorizationserver.domain.user.service;

import com.grace.authorizationserver.domain.user.User;
import com.grace.authorizationserver.domain.user.dto.UserInformation;
import com.grace.authorizationserver.domain.user.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("UserInformationService")
public class UserInformationService implements UserDetailsService {

    @Resource(name="UserRepository")
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        // 저장된 ID가 없을때 throw 시켜줍니다.
        if(user == null) {
            throw new UsernameNotFoundException("wrongId"); // 저장된 ID 없음
        }
        return makeLoginUser(user);
    }

    // UserInformation 값 주입 해 줍니다.
    public UserInformation makeLoginUser() {
        return makeLoginUser();
    }

    // UserInformation 값 주입 해 줍니다.
    public UserInformation makeLoginUser(User user) {

        UserInformation loginUser  = new UserInformation();

        List<GrantedAuthority> Authoritylist = new ArrayList<>();
        switch(user.getUserType()) {
            case 0 :
                // admin
                Authoritylist.add(new SimpleGrantedAuthority("ADMIN"));
            case 1 :
                // user
                Authoritylist.add(new SimpleGrantedAuthority("USER"));
                break;
        }

        loginUser.setUsername(user.getUsername());
        loginUser.setPassword(user.getPassword());
        loginUser.setAuthorities(Authoritylist);

        return loginUser;
    }
}
