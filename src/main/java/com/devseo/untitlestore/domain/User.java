package com.devseo.untitlestore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {
    private Long user_no;
    private String id;
    private String password;
    private String name;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User() {}
    public User(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
