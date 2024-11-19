package top.yyf.springboot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yyf.springboot.task.entity.StockPrice;
@Mapper
public interface StockPriceMapper extends BaseMapper<StockPrice> {
}
