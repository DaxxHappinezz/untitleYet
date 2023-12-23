package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.User;
import com.devseo.untitlestore.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    UserDao userDao;

    @GetMapping("/join")
    public String moveToJoin() {
        return "account/join";
    }

//    @PostMapping("/join")
//    public String registration(User user) {
//        System.out.println(user);
//        int rowCnt = this.userDao.insert(user);
//        if(rowCnt == 1) {
//            return "redirect:/";
//        }
//        return "redirect:/join";
//    }
    @PostMapping("/join")
    public String registration(User user) {
        System.out.println(user);
        int rowCnt = this.userDao.insert(user);
        if(rowCnt == 1) {
            return "redirect:/";
        }
        return "redirect:/join";
    }
}
