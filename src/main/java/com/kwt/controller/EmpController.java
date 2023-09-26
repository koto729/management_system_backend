package com.kwt.controller;

import com.kwt.pojo.Emp;
import com.kwt.pojo.PageBean;
import com.kwt.pojo.Result;
import com.kwt.service.DeptService;
import com.kwt.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("page: {},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("delete ");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("add successful");
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("find data by" + id);
        Emp emp = empService.findById(id);
        return Result.success(emp);
    }

    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("update data name = "+ emp.getName());
        empService.update(emp);
        return Result.success();
    }
}
