package com.devseo.untitlestore.domain;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notice {
    private int notice_no;
    private String title;
    private String content;
    private String id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private int views;

    public Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
