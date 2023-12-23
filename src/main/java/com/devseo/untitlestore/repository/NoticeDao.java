package com.devseo.untitlestore.repository;

import com.devseo.untitlestore.domain.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeDao {
    @Select("SELECT count(*) FROM notice")
    int count();
    @Insert("INSERT INTO notice (title, content, user_no) " +
            "VALUES (#{notice.title},#{notice.content},#{user_no})")
    int insert(@Param("notice") Notice notice, int user_no);
    @Select("SELECT notice_no, title, content, id, n.created, n.updated, views "+
            "FROM notice n " +
            "JOIN users u ON n.user_no = u.no " +
            "WHERE notice_no = #{notice_no}")
    Notice selectOne(int notice_no);
    @Select("SELECT notice_no, title, content, id, n.created, n.updated, views " +
            "FROM notice n " +
            "JOIN users u ON n.user_no = u.no ORDER BY notice_no DESC " +
            "LIMIT #{limit} OFFSET #{offset}")
    List<Notice> selectAll(int limit, int offset);
    @Update("UPDATE notice SET title = #{notice.title}, content = #{notice.content} " +
            "WHERE notice_no = #{notice.notice_no}")
    int update(@Param("notice") Notice notice);
    @Update("UPDATE notice SET views = views + 1 WHERE notice_no = #{notice_no}")
    void updateViewCnt(int notice_no);
    @Delete("DELETE FROM notice WHERE notice_no = #{notice.notice_no}")
    int delete(int notice_no);
    @Delete("TRUNCATE TABLE notice")
    void deleteAll();
}
