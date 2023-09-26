package com.kwt.mapper;

import com.kwt.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * from dept")
    List<Dept> list();

    @Delete("delete from dept WHERE id = #{id}")
    void deleteById(Integer id);

    @Insert("INSERT INTO dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void create(Dept dept);

    @Select("SELECT * from dept where id = #{id}")
    Dept findById(Integer id);

    @Update("UPDATE dept set name = #{name},create_time = #{createTime}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Integer id, String name, LocalDateTime createTime, LocalDateTime updateTime);
}
