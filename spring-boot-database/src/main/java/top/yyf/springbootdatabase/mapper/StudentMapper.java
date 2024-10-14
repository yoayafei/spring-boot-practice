package top.yyf.springbootdatabase.mapper;


import org.apache.ibatis.annotations.Param;
import top.yyf.springbootdatabase.entity.Student;

import java.util.List;

/**
 * @author mqxu
 * @date 2024/10/8
 * @description StudentMapper
 */
public interface StudentMapper {
    int insert(Student student);
    Student findStudentById(int studentId);
    int updateById(Student student);
    int deleteById(int studentId);
    int batchInsert(@Param("students") List<Student> students);
    int batchDelete(@Param("idList") List<Integer> ids);
    int batchUpdate(@Param("students") List<Student> students);
    List<Student> selectByDynamicSql(Student student);

    Student getStudentManyToOne(int studentId);

    Student getStudent(int studentId);
}