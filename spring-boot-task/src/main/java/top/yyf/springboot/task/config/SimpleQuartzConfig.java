package top.yyf.springboot.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yyf.springboot.task.jobs.SimpleQuartzTask;

@Configuration
public class SimpleQuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(SimpleQuartzTask.class)
                .withIdentity("simpleQuartzTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        // 指定定时任务的执行规则,每5秒执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("simpleQuartzTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
