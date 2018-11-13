package com.sda.spring.demo.component;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SecurityFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println(servletRequest.getRemoteAddr());
        if (servletRequest.getRemoteAddr().equals("127.0.0.1")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            servletResponse.getWriter().write("Not allowed!");
        }
    }

    @Override
    public void destroy() {

    }
}
