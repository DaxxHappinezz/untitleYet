package com.devseo.untitlestore.controller;

import com.devseo.untitlestore.domain.Notice;
import com.devseo.untitlestore.domain.User;
import com.devseo.untitlestore.repository.NoticeDao;
import com.devseo.untitlestore.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyControllerTest {
    @Autowired
    UserDao userDao;
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

    @Test
    public void insertTestUser() {
        this.userDao.deleteAll();
        User user = new User("test2","1234","test@test.com","testman","01022223333", LocalDate.of(2023, 10, 7),"","",false);
        int rowCnt = this.userDao.insert(user);
        User user2 = this.userDao.selectById("test2");
        assertEquals(1, rowCnt);
        assertEquals("test2", user2.getId());
        System.out.println("rowCnt: "+rowCnt);
        System.out.println("user2: "+user2);
    }
}