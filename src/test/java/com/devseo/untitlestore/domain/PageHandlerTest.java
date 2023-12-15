package com.devseo.untitlestore.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageHandlerTest {
    @Test
    public void pagingTest() {
        PageHandler ph = new PageHandler(200, 3);
        System.out.println("current page: "+ph.getPage());
        ph.print();
    }

    @Test
    public void pagingTest2() {
        PageHandler ph = new PageHandler(201, 9);
        System.out.println(ph);
        System.out.println("current page: "+ph.getPage());
        ph.print();
        assert (ph.getBeginPage() == 1);
        assert (ph.getTotalPage() == 21);
    }
}