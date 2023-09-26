package com.kwt.controller;

import com.kwt.pojo.Dept;
import com.kwt.pojo.Result;
import com.kwt.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        log.info("select all data");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("delete data by id = " + id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result create(@RequestBody Dept dept){
        log.info("Create a " + dept);
        deptService.create(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("find data by id = " + id);
        Dept deptList = deptService.findById(id);
        return Result.success(deptList);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("Update a " + dept);
        deptService.update(dept);
        return Result.success();
    }
}
