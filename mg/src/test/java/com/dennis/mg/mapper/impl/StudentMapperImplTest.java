package com.dennis.mg.mapper.impl;

import com.dennis.mg.mapper.StudentMapper;
import com.dennis.mg.po.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class StudentMapperImplTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void save() {
        Student student = new Student();
        student.setId("2").setName("zs").setSex("man").setIntroduce("like money");
        studentMapper.save(student);
    }

    @Test
    void update() {
        Student student = new Student();
        student.setName("ss").setSex("man").setIntroduce("like gold").setId("2");
        studentMapper.update(student);
    }

    @Test
    void findAll() {
        List<Student> all = studentMapper.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void delete() {
        studentMapper.delete("2");
    }
}