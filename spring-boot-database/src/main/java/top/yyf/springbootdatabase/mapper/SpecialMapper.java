package top.yyf.springbootdatabase.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.yyf.springbootdatabase.entity.Special;

import java.util.List;
@Mapper
public interface SpecialMapper {
    List<Special> findAll();
}
