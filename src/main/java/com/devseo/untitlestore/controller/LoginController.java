package com.devseo.untitlestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String moveToLogin() {
        return "account/login";
    }

    @PostMapping("/login")
    public String loginSubmit(String id, String password) {
        System.out.println("id: "+id+" | pwd: "+password);
        if (!loginCheck(id, password)) {
            return "account/login";
        }
        return "redirect:/";
    }

    private boolean loginCheck(String id, String password) {
        boolean rs = "test".equals(id) && "1234".equals(password);
        System.out.println(rs);
        return "test".equals(id) && "1234".equals(password);
    }
}
