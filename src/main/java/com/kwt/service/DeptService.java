package com.kwt.service;

import com.kwt.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void deleteById(Integer id);

    void create(Dept dept);

    void update(Dept dept);

    Dept findById(Integer id);
}
