package top.yyf.springboot.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //请求资源的路径
        String path = request.getRequestURI();
        //请求的酷虎端地址
        String clientIp = request.getRemoteAddr();
        //请求开始的时间
        LocalDateTime beginTime = LocalDateTime.now();
        log.info("请求已经到达过滤器：path:{},clientIp:{},beginTime:{}", path, clientIp, beginTime);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器响应处理完毕: path:{},endTime:{}", path, beginTime);
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter 销毁");
    }
}
