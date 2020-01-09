package com.dennis.mg.mapper;

import com.dennis.mg.po.Student;

import java.util.List;

/**
 * 描述：
 *
 * @author Liaopeng
 * @version 1.0
 * @date 2020/1/3 14:55
 */
public interface StudentMapper {

    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    void delete(String id);
}
