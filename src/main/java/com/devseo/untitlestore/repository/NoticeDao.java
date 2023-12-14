package com.devseo.untitlestore.repository;

import com.devseo.untitlestore.domain.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeDao {
    @Select("SELECT count(*) FROM notice")
    int count();
    @Insert("INSERT INTO notice (title, content, user_no) " +
            "VALUES (#{notice.title},#{notice.content},#{notice.user_no})")
    int insert(@Param("notice") Notice notice, int user_no);
    @Select("SELECT notice_no, title, content, id, n.created, n.updated, views "+
            "FROM notice n " +
            "JOIN users u ON n.user_no = u.user_no " +
            "WHERE notice_no = #{notice_no}")
    Notice selectOne(int notice_no);
    @Select("SELECT notice_no, title, content, id, n.created, n.updated, views " +
            "FROM notice n " +
            "JOIN users u ON n.user_no = u.user_no ORDER BY notice_no DESC")
    List<Notice> selectAll();
    @Update("UPDATE notice SET title = #{notice.title}, content = #{notice.content} " +
            "WHERE notice_no = #{notice.notice_no} AND user_no = #{notice.user_no}")
    int update(@Param("notice") Notice notice, int user_no);
    @Delete("DELETE FROM notice WHERE notice_no = #{notice.notice_no} AND user_no = #{notice.user_no}")
    int delete(int notice_no, int user_no);
    @Delete("TRUNCATE TABLE notice")
    void deleteAll();
}
