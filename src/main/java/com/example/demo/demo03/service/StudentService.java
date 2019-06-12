package com.example.demo.demo03.service;

import com.example.demo.demo03.domain.Student;

/**
 * @auther kklu
 * @date 2019/6/12 15:28
 * @describe
 */

public interface StudentService {
    /**
     * 新增一个Student对象
     * @param student
     * @return
     */
    Student save(Student student);

    /**
     * 通过用户名来查找 Student 对象
     * @param name
     * @return
     */
    Student findByName(String name);
}
