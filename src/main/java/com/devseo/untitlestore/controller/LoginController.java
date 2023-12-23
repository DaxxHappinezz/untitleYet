package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.User;
import com.devseo.untitlestore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String moveToLogin() {
        return "account/login";
    }

    @PostMapping("/login")
    public String loginSubmit(String id, String password, HttpServletRequest request) {
        if (!loginCheck(id, password)) {
            return "account/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("login", true);
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    private boolean loginCheck(String id, String password) {
        User user= this.userService.getUser(id);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }
}
