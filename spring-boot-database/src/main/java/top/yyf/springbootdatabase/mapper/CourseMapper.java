package top.yyf.springbootdatabase.mapper;

import top.yyf.springbootdatabase.entity.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectAll();
}
