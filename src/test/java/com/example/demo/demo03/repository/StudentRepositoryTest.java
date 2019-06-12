package com.example.demo.demo03.repository;

import com.example.demo.demo03.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther kklu
 * @date 2019/6/11 18:47
 * @describe
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(StudentRepositoryTest.class);

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 添加一条数据
     */
    @Test
    public void save() {
        //场景 student 示例并添加数据
        Student student = new Student();
        student.setName("jack");
        student.setAge(16);
        // 通过 StudentRepository 接口实现数据存储到数据表中
        Student result = studentRepository.save(student);
        //打印下结果
        log.info("添加数据 name={},age={}", result.getName(), result.getAge());
        //打印结果
        //Hibernate: insert into student (age, name) values (?, ?)
        //INFO 8460 --- [           main] c.e.d.d.r.StudentRepositoryTest          : 添加数据 name=jack,age=16
    }

    /**
     * 通过id来删除数据，删除数据没有返回值
     */
    @Test
    public void delete() {
        studentRepository.deleteById(1L);
    }


    /**
     * 更新数据,把name为jack 改为 role
     */
    @Test
    public void update() {
        //1.通过某个id来找数据
        Student result = studentRepository.findById(1L).orElse(null);
        //
        if (result != null) {
            log.info("更新前的数据 name={},age={}", result.getName(), result.getAge());
            result.setName("role");
            //保存和更新都用save()，但要保证 自增id不变即可
            Student findPO = studentRepository.save(result);
            log.info("更新后的数据 name={},age={}", findPO.getName(), findPO.getAge());
        } else {
            log.info("数据不存在，不能更新");
        }
        //打印日志，结果是hi更新成功
        //2019-06-11 19:12:50.008  INFO 2432 --- [           main] c.e.d.d.r.StudentRepositoryTest          : 更新前的数据 name=jack,age=16
        //Hibernate: select student0_.id as id1_0_0_, student0_.age as age2_0_0_, student0_.name as name3_0_0_ from student student0_ where student0_.id=?
        //Hibernate: update student set age=?, name=? where id=?
        //2019-06-11 19:12:50.069  INFO 2432 --- [           main] c.e.d.d.r.StudentRepositoryTest          : 更新后的数据 name=role,age=16
    }

    /**
     * 通过名称查找数据
     */
    @Test
    public void findByName() {
        Student result = studentRepository.findByName("role");
        if (result != null) {
            log.info("查找的数据 name={},age={}", result.getName(), result.getAge());
        } else {
            log.info("没有名称为 role 学生");
        }
        //打印结果
        //c.e.d.d.r.StudentRepositoryTest          : 查找的数据 name=role,age=16
    }

}