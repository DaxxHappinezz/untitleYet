package com.devseo.untitlestore.repository;

import com.devseo.untitlestore.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("SELET count(*) FROM users")
    int count();
    @Insert("INSERT INTO users (id, password, name, email) " +
            "VALUES(#{user.id},#{user.password},#{user.name},#{user.email})")
    int insert(@Param("user") User user);
    void selectOne();
    void selectAll();
    void update();
    void delete();
    void deleteAll();
}
