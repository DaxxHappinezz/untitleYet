package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
    @GetMapping("/list")
    public void getList(Model model) {
        List<Notice> noticeList = this.noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
    }
    @GetMapping("/write")
    public String moveToWrite() {
        return "notice/notice";
    }
}
