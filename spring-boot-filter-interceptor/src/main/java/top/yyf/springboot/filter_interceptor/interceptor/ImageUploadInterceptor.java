package top.yyf.springboot.filter_interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tika.Tika;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import javax.imageio.ImageIO;

@Component
public class ImageUploadInterceptor implements HandlerInterceptor {

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB
    private static final int MAX_WIDTH = 1920; // 最大宽度
    private static final int MAX_HEIGHT = 1080; // 最大高度
    private static final String UPLOAD_DIR = "/upload/";
    private static final String WATERMARK_TEXT = "水印"; // 设置中文水印文字

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(request instanceof MultipartHttpServletRequest)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid Request");
            return false;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        for (MultipartFile file : multipartRequest.getFiles("file")) {
            // 文件类型检查
            if (!isImage(file)) {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                response.getWriter().write("Invalid File Type");
                return false;
            }

            // 文件大小限制
            if (file.getSize() > MAX_FILE_SIZE) {
                response.setStatus(HttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE);
                response.getWriter().write("File Too Large");
                return false;
            }

            // 图片尺寸检查
            if (!isValidImageSize(file)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Invalid Image Dimensions");
                return false;
            }


            // 确保上传目录存在
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

                // 文件重命名
                String uniqueFileName = renameFile(file);
//
//
//           // 添加水印并保存图片
//            BufferedImage imageWithWatermark = addWatermark(file);
//            String uniqueFileName = renameFile(file);
//            File outputFile = new File(uploadDir, uniqueFileName);
//            ImageIO.write(imageWithWatermark, "png", outputFile); // 以PNG格式保存图片








        }
        return true;
    }



    private boolean isImage(MultipartFile file) throws IOException {
        Tika tika = new Tika();
        String detectedType = tika.detect(file.getInputStream());
        System.out.println("Detected file type: " + detectedType);
        return detectedType.startsWith("image/png");
    }


    private boolean isValidImageSize(MultipartFile file) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        return image.getWidth() <= MAX_WIDTH && image.getHeight() <= MAX_HEIGHT;
    }

    private String renameFile(MultipartFile file) {
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 创建一个Random对象用于生成随机数
        Random random = new Random();
        // 生成一个1到10之间的随机整数
        int randomNumber = random.nextInt(10) + 1;
        // 使用随机数生成唯一的文件名，并保留原始扩展名
        return randomNumber + extension;
    }


    private BufferedImage addWatermark(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        Graphics2D g2d = (Graphics2D) originalImage.getGraphics();

        // 设置水印属性
        g2d.setColor(new Color(255, 255, 255, 128)); // 白色，具有透明度
        Font font = new Font("SimSun", Font.BOLD, 30); // 使用支持中文的字体，例如宋体
        g2d.setFont(font);
        g2d.drawString(WATERMARK_TEXT, originalImage.getWidth() / 10, originalImage.getHeight() / 10); // 水印位置

        g2d.dispose(); // 释放图形上下文
        return originalImage;
    }


    private void logUpload(MultipartFile file) {
        System.out.println("File uploaded: " + file.getOriginalFilename() + " at " + LocalDateTime.now());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 可以选择在请求完成后进一步处理日志或清理资源
    }
}
