package yyf.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {
    @GetMapping("/msg")
    public String getMsg(Model model) {
        //将“message"属性传到试图
        model.addAttribute("message","Hello,Thymeleaf111");
        //返回的试图名称：默认在 resource/templates/msg.html
        return "msg";
    }
}
