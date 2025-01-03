package top.yyf.springboot.task.jobs;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import top.yyf.springboot.task.entity.Student;
import top.yyf.springboot.task.mapper.StudentMapper;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class ExportJob extends QuartzJobBean {
    protected final StudentMapper studentMapper;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行导出任务!");
        List<Student> students = studentMapper.selectList(null);
        String fileName = "/Users/86151/Desktop/export/" + UUID.randomUUID() + ".xlsx";
        EasyExcel.write(fileName,Student.class)
                .sheet("学生数据")
                .doWrite(()->students);
    }
}
