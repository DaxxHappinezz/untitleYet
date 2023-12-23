package com.devseo.untitlestore.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {
    private Long no;
    private String id;
    private String password;
    private String email;
    private String name;
    private String phone;
    private LocalDate birth;
    private String address;
    private String detail_addr;
    private boolean subscribe;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User() {}
    public User(String id, String password, String email, String name, String phone, LocalDate birth, String address, String detail_addr, boolean subscribe) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.address = address;
        this.detail_addr = detail_addr;
        this.subscribe = subscribe;
    }
}
