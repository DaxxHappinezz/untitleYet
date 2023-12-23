package com.devseo.untitlestore.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JoinInfo {
    private String id;
    private String password;
    private String confirmPwd;
    private String email;
    private String name;
    private LocalDate birth;
    private String phone;
    private String fullAddress;
    private String extraAddress;
    private boolean privacy;
}
