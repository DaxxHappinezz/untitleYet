package com.devseo.untitlestore.service;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.repository.NoticeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeDao noticeDao;
    NoticeService(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    public int getCount() {
        return this.noticeDao.count();
    }
    public int write(Notice notice, int user_no) {
        return this.noticeDao.insert(notice, user_no);
    }
    public Notice read(int notice_no) {
        return this.noticeDao.selectOne(notice_no);
    }
    public List<Notice> getNoticeList(int limit, int offset) {
        return this.noticeDao.selectAll(limit, offset);
    }
    public int modify(Notice notice, int user_no) {
        return this.noticeDao.update(notice, user_no);
    }
    public int remove(int notice_no, int user_no) {
        return this.noticeDao.delete(notice_no, user_no);
    }
    public void emptyNotice() {
        this.noticeDao.deleteAll();
    }
}
