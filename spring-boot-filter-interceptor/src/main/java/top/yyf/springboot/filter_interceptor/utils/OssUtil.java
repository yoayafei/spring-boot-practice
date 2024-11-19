package top.yyf.springboot.filter_interceptor.utils;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.yyf.springboot.filter_interceptor.config.OssConfig;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;

@Component
public class OssUtil {
    @Resource
    private OSS ossClient;

    @Resource
    private OssConfig ossConfig;

    public String uploadFile(MultipartFile file) {
        Random random = new Random();
        int randomNumber = random.nextInt(10)+1;
        try {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名不能为空");
            }
//            String fileName = "upload/" + UUID.randomUUID() +"_" +originalFilename;
            String fileName ="upload/"+ randomNumber +originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            return "https://"+ ossConfig.getBucketName() +"." + ossConfig.getEndpoint().replace("https://","")+ "/" + fileName;
        }catch (Exception e) {
            throw new RuntimeException("文件上传失败",e);
        }
    }

    public String uploadFile(byte[] fileBytes, String fileName) {
        try (InputStream inputStream = new ByteArrayInputStream(fileBytes)) {
            // 上传文件到OSS
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            // 构建文件的URL路径
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint().replace("https://", "") + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("文件上传失败", e);
        }
    }

}
