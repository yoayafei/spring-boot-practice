package top.yyf.springboot.mp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.yyf.springboot.mp.entity.Clazz;
import top.yyf.springboot.mp.entity.Teacher;
import top.yyf.springboot.mp.mapper.ClazzMapper;

@Service
@AllArgsConstructor
public class ClazzService {
    private final ClazzMapper clazzMapper;
    /**
     * 根据班级ID获取班级和对应⽼师
     */
    public Clazz getClazzWithTeacher(Long clazzId) {
        Clazz clazz = clazzMapper.selectById(clazzId);
        if (clazz != null) {
            Teacher teacher = clazzMapper.selectTeacherByClazzId(clazz.getTeacherId());
            clazz.setTeacher(teacher);
        }
        return clazz;
    }
}