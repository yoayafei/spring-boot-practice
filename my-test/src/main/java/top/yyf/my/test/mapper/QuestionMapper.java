package top.yyf.my.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yyf.my.test.entity.Question;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
}
