package com.example.demo.demo03.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @auther kklu
 * @date 2019/6/5 18:47
 * @describe
 */

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1546546324464618465L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
