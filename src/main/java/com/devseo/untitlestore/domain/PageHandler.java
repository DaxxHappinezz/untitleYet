package com.devseo.untitlestore.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageHandler {
    private int totalNotice;
    private int totalPage;
    private int pageSize;
    private int page;
    private int naviSize;
    private int beginPage;
    private int endPage;
    private boolean showPrev = false;
    private boolean showNext = false;

    public PageHandler(int totalNotice, int page) {
        this(totalNotice, page, 10);
    }

    public PageHandler(int totalNotice, int page, int pageSize) {
        this.totalNotice = totalNotice;
        this.pageSize = pageSize;
        this.page = page;

        totalPage = (int)Math.ceil(totalNotice / (double)10);

        // page 3, bp = 1 ep = 10 | page 14, bp = 11 ep = 20
        beginPage = (page - 1) / 10 * 10 + 1;
        endPage = beginPage + 10 - 1;
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.print(showPrev ? "[PREV] " : "");
        for (int i = beginPage; i<=endPage; i++) {
            System.out.print(i+" ");
        }
        System.out.print(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalNotice=" + totalNotice +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", naviSize=" + naviSize +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
