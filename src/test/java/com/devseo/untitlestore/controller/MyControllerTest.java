package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.repository.NoticeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyControllerTest {

    @Autowired
    NoticeDao noticeDao;

    @Test
    public void insertTest() {
        Notice notice = new Notice("test insert title", "test insert content");
        int rowCnt = this.noticeDao.insert(notice, 1);
        if (rowCnt == 1) {
            System.out.println("insert success");
        }
    }

    @Test
    public void insertTestData() {
        this.noticeDao.deleteAll();
        for (int i = 1; i <=200; i++) {
            Notice notice = new Notice("test title " + i, "test content " + i);
            this.noticeDao.insert(notice, 1);
        }
        System.out.println("notice count: "+this.noticeDao.count());
    }

    @Test
    public void selectOneTest() {
        Notice notice = this.noticeDao.selectOne(20);
        System.out.println("notice: "+notice);
    }
}