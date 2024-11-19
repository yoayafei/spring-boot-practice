package top.yyf.springboot.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("AuthFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取Authorization请求头
        String authToken = request.getHeader("Authorization");
        //是匹配的授权令牌
        if("hello".equals(authToken)) {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //返回401来认证错误
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("UNAUTHORIZED!");
        }
    }

    @Override
    public void destroy() {
        log.info("AuthFilter destroy");
    }
}
