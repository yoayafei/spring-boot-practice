package top.yyf.springboot.mp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Clazz {
    private Long id;
    private String name;
    private Long teacherId;

    //声明数据表中不村子啊 teacher 列，一对一
    @TableField(exist = false)
    private Teacher teacher;
}
