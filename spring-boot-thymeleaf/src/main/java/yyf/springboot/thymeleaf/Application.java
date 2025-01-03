package yyf.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping
    public String hello(String name)   {
        String greeting = "Hello,"+name;
        return greeting;
    }

    @GetMapping("/sum")
    public Integer sum(int a) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum +=i;
        }
        return sum;
    }
}
