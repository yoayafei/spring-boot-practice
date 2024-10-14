package top.yyf.springbootdatabase.mapper;

import top.yyf.springbootdatabase.entity.Teacher;

public interface TeacherMapper {
    // 根据id查询教师信息
    Teacher findTeacherById(int teacherId);

}
