package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.repository.NoticeDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    private final NoticeDao noticeDao;
    public MyController(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @GetMapping("/")
    public String test(Model model) {
        int rowCnt = this.noticeDao.count();
        model.addAttribute("notice_cnt", rowCnt);
        return "index";
    }
}
