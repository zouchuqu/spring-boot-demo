package com.example.demo.demo03.repository;

import com.example.demo.demo03.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther kklu
 * @date 2019/6/11 17:36
 * @describe
 */

/**
 * 继承JpaRepository<T,K>，第一个泛型参数是实体对象的名称，第二个是主键类型
 *  JpaRepository 默认实现了部分CRUD，所以可以直接使用这些简单的功能了，不需要自己实现了。
 *  没有默认实现的功能，我们可以根据JPA语法规范写好接口即可，
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    /**
     * 通过 name 查询学生信息
     * @param name
     * @return
     */
    Student findByName(String name);
}
