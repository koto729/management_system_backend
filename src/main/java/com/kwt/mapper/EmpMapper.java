package com.kwt.mapper;

import com.kwt.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    //search total count of data
//    @Select("SELECT count(*) from emp")
//    long count();



    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    void delete(List<Integer> ids);


    @Insert("INSERT into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUE(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime}) ")
    void add(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp findById(Integer id);






    @Update("update emp set username = #{username},name = #{name}, gender = #{gender}, image = #{image}, job = #{job}," +
            " entrydate = #{entrydate}, dept_id = #{deptId}, create_time = #{createTime}, update_time = #{updateTime} " +
            "WHERE id = #{id}")
    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(Emp emp);
}
