package com.devseo.untitlestore.repository;

import com.devseo.untitlestore.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT count(*) FROM users")
    int count();
    @Insert("INSERT INTO users (id, password, email, name, phone, birth, address, detail_addr, subscribe) " +
            "VALUES(#{user.id},#{user.password},#{user.email},#{user.name},#{user.phone},#{user.birth},#{user.address},#{user.detail_addr},#{user.subscribe})")
    int insert(@Param("user") User user);
    @Select("SELECT * FROM users where id = #{id}")
    User selectById(String id);
    @Select("SELECT * FROM users")
    List<User> selectAll();
    @Update("UPDATE users SET password = #{user.password}, email = #{user.email}, phone = #{user.phone}, address = #{user.address}, detail_addr = #{user.detail_addr}, subscribe = #{user.subscribe} " +
            "WHERE no = #{user.no}")
    int update(@Param("user") User user);
    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(String id);
    @Delete("TRUNCATE TABLE users")
    void deleteAll();
}
