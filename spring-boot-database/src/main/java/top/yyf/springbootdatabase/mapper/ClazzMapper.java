package top.yyf.springbootdatabase.mapper;

import top.yyf.springbootdatabase.entity.Clazz;

public interface ClazzMapper {
    Clazz getClazzById(int clazzId);

    Clazz getClazz(int clazzId);
}
