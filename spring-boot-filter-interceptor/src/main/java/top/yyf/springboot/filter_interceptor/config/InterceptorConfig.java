package top.yyf.springboot.filter_interceptor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yyf.springboot.filter_interceptor.interceptor.AuthInterceptor;
import top.yyf.springboot.filter_interceptor.interceptor.CORSInterceptor;
import top.yyf.springboot.filter_interceptor.interceptor.ImageUploadInterceptor;
import top.yyf.springboot.filter_interceptor.interceptor.LoggingInterceptor;

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    private final AuthInterceptor authInterceptor;
    private final CORSInterceptor corsInterceptor;
    private final ImageUploadInterceptor imageUploadInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加了loggingInterceptor拦截器，并添加了拦截地址
//        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(imageUploadInterceptor).addPathPatterns("/**");
    }
}
