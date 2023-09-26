package com.kwt.service;

import com.kwt.pojo.Emp;
import com.kwt.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender,
                  LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp findById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
