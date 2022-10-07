package com.itheima.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        //判断访问资源路径是否和登录注册相关
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/register.jsp", "registerServlet", "/checkCodeServlet", "/loginServlet"};
        //获取当前资源的访问路径
        String url = request1.getRequestURL().toString();

        //循环判断
        for (String u : urls) {
            if (url.contains(u)) {
                //找到了

                //放行
                chain.doFilter(request, response);

                return;
            }

        }

        //1. 判断session中是否有user
        HttpSession session = request1.getSession();
        Object user = session.getAttribute("user");

        //2.判断user是否为空
        if (user != null) {
            //登录过
            //放行
            chain.doFilter(request, response);
        } else {
            //没有登录，存储信息，跳转到登陆页面

            request1.setAttribute("login_msg", "你尚未登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
