package top.yyf.springboot.configure.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestBeanServiceTest {
    //注入Spring上下文
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    void test() {
       TestBeanService testBeanService=(TestBeanService) ioc.getBean("testBeanService");
        System.out.println(testBeanService.getName());
    }
}