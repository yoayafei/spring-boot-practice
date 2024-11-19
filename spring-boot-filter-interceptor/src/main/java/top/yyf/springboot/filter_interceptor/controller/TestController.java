package top.yyf.springboot.filter_interceptor.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yyf.springboot.filter_interceptor.utils.OssUtil;

@RestController
@AllArgsConstructor
public class TestController {
    private final OssUtil ossUtil;


    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file){
        return ossUtil.uploadFile(file);
    }
}
