package top.yyf.springboot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.yyf.springboot.mp.entity.Clazz;
import top.yyf.springboot.mp.entity.Teacher;

public interface ClazzMapper extends BaseMapper<Clazz> {

    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    Teacher selectTeacherByClazzId(Long teacherId);

}
