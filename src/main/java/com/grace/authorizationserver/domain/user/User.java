package com.grace.authorizationserver.domain.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", length = 20, unique = true, nullable = false)
    private String username;

    @Column(length = 400, nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private int userType;

    @Column(nullable = false)
    private Date date;
}
