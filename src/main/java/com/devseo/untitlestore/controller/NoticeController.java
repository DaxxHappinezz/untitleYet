package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.domain.PageHandler;
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
    public void getList(Integer page, Integer pageSize, Model model) {
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        int rowCnt = this.noticeService.getCount();
        PageHandler ph = new PageHandler(rowCnt, page, pageSize);
        System.out.println("ph: "+ph);
        model.addAttribute("ph", ph);
        List<Notice> noticeList = this.noticeService.getNoticeList(pageSize, (page - 1) * 10);
        model.addAttribute("noticeList", noticeList);
    }
    @GetMapping("/write")
    public String moveToWrite() {
        return "notice/notice";
    }

    @GetMapping("/read")
    public String moveToRead(Integer notice_no, Integer page, Integer pageSize, Model model) {
        if (pageSize == null) pageSize = 10;
        int rowCnt = this.noticeService.getCount();
        PageHandler ph = new PageHandler(rowCnt, page, pageSize);
        model.addAttribute("ph", ph);
        model.addAttribute("notice", this.noticeService.read(notice_no));
        return "notice/notice";
    }

}
