package top.yyf.springboot.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.yyf.springboot.task.entity.EmailLog;
import top.yyf.springboot.task.mapper.EmailLogMapper;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final EmailLogMapper emailLogMapper;

    public void sendMail(String to, String subject, String content) {
        //1.发送邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("2505114181@qq.com");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);

        //2.将发送记录存入数据库
        EmailLog emailLog = new EmailLog();
        emailLog.setRecipient(to);
        emailLog.setSubject(subject);
        emailLog.setContent(content);
        emailLog.setSendAt(LocalDateTime.now());
        emailLogMapper.insert(emailLog);

        //3.控制台输出日志
        log.info("邮件已发送至：{}",to);
    }
}
