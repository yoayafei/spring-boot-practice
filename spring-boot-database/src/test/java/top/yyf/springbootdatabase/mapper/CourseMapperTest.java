package top.yyf.springbootdatabase.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yyf.springbootdatabase.entity.Course;
import top.yyf.springbootdatabase.entity.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j

class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void selectAll() {
        List<Course> courses = courseMapper.selectAll();
        courses.forEach(course -> {
            log.info("课程名称: {}", course.getCourseName());
            log.info("选课学生如下: ");
            List<Student> students = course.getStudents();
            students.forEach(student -> {
                log.info("{},{}.{}.{}", student.getStudentId(), student.getStudentName(),student.getHometown(),student.getBirthday());
            });

        });
    }
}