package com.devseo.untitlestore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NoticeDao {
    @Select("SELECT count(*) from notice")
    int count();
}
