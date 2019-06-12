package com.example.demo.demo03.controller;

import com.example.demo.demo03.domain.Student;
import com.example.demo.demo03.form.StudentForm;
import com.example.demo.demo03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther kklu
 * @date 2019/6/12 15:44
 * @describe
 */

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping
    public Object save(StudentForm studentForm) {
        Student student = new Student();
        student.setName(studentForm.getName());
        student.setAge(studentForm.getAge());
        Student result = studentService.save(student);
        return result;
    }

    @GetMapping
    public Object findByName(String name) {
        Student result = studentService.findByName(name);
        return result;
    }

}
