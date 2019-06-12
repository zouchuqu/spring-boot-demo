package com.example.demo.demo03.service.impl;

import com.example.demo.demo03.domain.Student;
import com.example.demo.demo03.repository.StudentRepository;
import com.example.demo.demo03.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther kklu
 * @date 2019/6/12 15:38
 * @describe
 */

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 新增一个Student对象
     *
     * @param student
     * @return
     */
    @Override
    public Student save(Student student) {
        //在这里处理业务逻辑，这里要看具体情况处理
        Student result = studentRepository.save(student);
        //打印下结果
        log.info("添加数据 name={},age={}", result.getName(), result.getAge());
        return result;
    }

    /**
     * 通过用户名来查找 Student 对象
     *
     * @param name
     * @return
     */
    @Override
    public Student findByName(String name) {
        //在这里处理业务逻辑，这里要看具体情况处理
        Student result = studentRepository.findByName(name);
        log.info("添加数据 name={},age={}", result.getName(), result.getAge());
        return result;
    }

}
