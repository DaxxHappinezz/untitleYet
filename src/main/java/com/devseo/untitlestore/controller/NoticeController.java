package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.domain.PageHandler;
import com.devseo.untitlestore.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("ph", ph);
        List<Notice> noticeList = this.noticeService.getNoticeList(pageSize, (page - 1) * 10);
        model.addAttribute("noticeList", noticeList);
    }
    @GetMapping("/write")
    public String moveToWrite(Integer page, Integer pageSize, Model model) {
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        int rowCnt = this.noticeService.getCount();
        PageHandler ph = new PageHandler(rowCnt, page, pageSize);
        model.addAttribute("ph", ph);
        model.addAttribute("mode", "write");
        return "notice/notice";
    }

    @PostMapping("/write")
    public String submit(String title, String content, RedirectAttributes rattr) {
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            rattr.addFlashAttribute("title", title);
            rattr.addFlashAttribute("content", content);
            rattr.addFlashAttribute("error", "* 제목과 내용을 모두 입력해주세요.");
            return "redirect:/notice/write";
        }
        Notice notice = new Notice(title, content);
        int rowCnt = this.noticeService.write(notice, 1);
        if (rowCnt == 1) {
            return "redirect:/notice/list";
        }
        rattr.addFlashAttribute("error", "작성 중 오류가 발생했습니다.");
        return "redirect:/notice/write";
    }

    @GetMapping("/read")
    public String moveToRead(Integer notice_no, Integer page, Integer pageSize, Model model) {
        this.noticeService.addViewCnt(notice_no);
        if (pageSize == null) pageSize = 10;
        int rowCnt = this.noticeService.getCount();
        PageHandler ph = new PageHandler(rowCnt, page, pageSize);
        model.addAttribute("ph", ph);
        model.addAttribute("notice", this.noticeService.read(notice_no));
        model.addAttribute("mode", "read");
        return "notice/notice";
    }

    @GetMapping("/modify")
    public String moveToModify(Integer notice_no, Integer page, Integer pageSize, Model model) {
        if (pageSize == null) pageSize = 10;
        int rowCnt = this.noticeService.getCount();
        PageHandler ph = new PageHandler(rowCnt, page, pageSize);
        model.addAttribute("ph", ph);
        model.addAttribute("notice", this.noticeService.read(notice_no));
        model.addAttribute("mode", "modify");
        return "notice/notice";
    }

    @PostMapping("/modify")
    public String modified(Integer notice_no, String title, String content, Integer page, Integer pageSize, RedirectAttributes rattr) {
        if (pageSize == null) pageSize = 10;
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            rattr.addAttribute("notice_no", notice_no);
            rattr.addAttribute("title", title);
            rattr.addAttribute("content", content);
            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("error", "* 제목과 내용을 모두 입력해주세요.");
            return "redirect:/notice/modify";
        }
        Notice notice = new Notice(notice_no, title, content);
        int rowCnt = this.noticeService.modify(notice);
        if (rowCnt == 1) {
            rattr.addAttribute("notice_no", notice_no);
            rattr.addAttribute("page", page);
            return "redirect:/notice/read";
        }
        rattr.addAttribute("notice_no", notice_no);
        rattr.addAttribute("title", title);
        rattr.addAttribute("content", content);
        rattr.addAttribute("page", page);
        rattr.addAttribute("pageSize", pageSize);
        rattr.addAttribute("error", "작성 중 오류가 발생했습니다.");
        return "redirect:/notice/modify";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int notice_no) {
        int rowCnt = this.noticeService.remove(notice_no);
        if (rowCnt == 1) {
            return "redirect:/notice/list";
        }
        return "redirect:/notice/modify";
    }
}
