package top.yyf.springboot.file.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.yyf.springboot.file.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class OssTemplate {
    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    public String ossUpload(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名不能为空");
            }
            String fileName = UUID.randomUUID().toString() +"_" +originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucket(), fileName, inputStream);
            return "https://"+ossConfig.getBucket() +"." + ossConfig.getEndpoint().replace("https://","")+ "/" + fileName;
        }catch (Exception e) {
            throw new RuntimeException("文件上传失败",e);
        }
    }
}