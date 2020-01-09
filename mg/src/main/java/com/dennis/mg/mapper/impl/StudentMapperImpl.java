package com.dennis.mg.mapper.impl;

import com.dennis.mg.mapper.StudentMapper;
import com.dennis.mg.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author Liaopeng
 * @version 1.0
 * @date 2020/1/3 14:59
 */
@Service
public class StudentMapperImpl implements StudentMapper {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Student student) {
        mongoTemplate.save(student);
    }

    @Override
    public void update(Student student) {
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update();
        update.set("name", student.getName()).set("introduce", student.getIntroduce());
        mongoTemplate.updateFirst(query, update, Student.class);
    }

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override

    public void delete(String id) {
        Student byId = mongoTemplate.findById(id, Student.class);
        mongoTemplate.remove(byId);
    }
}
