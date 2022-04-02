package com.grace.authorizationserver.domain.user.repository;

import com.grace.authorizationserver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
