package top.yyf.springboot.task.jobs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.yyf.springboot.task.entity.StockPrice;
import top.yyf.springboot.task.mapper.StockPriceMapper;

import java.time.LocalDateTime;
import java.util.Random;

//@Component
@AllArgsConstructor
@Slf4j
public class StockPriceTask {
    private final StockPriceMapper stockPriceMapper;

    private final Random random = new Random();

    @Scheduled(fixedRate = 10000)
    public void updateStockPrice() {
        double price = 100 + random.nextDouble() * 50;
        price = Double.parseDouble(String.format("%.2f", price));

        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(price);
        stockPrice.setName("小米");
        stockPrice.setUpdateTime(LocalDateTime.now());

        //插入数据库
        stockPriceMapper.insert(stockPrice);
        log.info("股票价格已更新：{}，时间：{}",price,LocalDateTime.now());
    }
}
