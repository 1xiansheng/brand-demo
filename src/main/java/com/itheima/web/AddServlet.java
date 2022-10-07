package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private final BrandService BRAND_SERVICE = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post请求乱码
        request.setCharacterEncoding("utf-8");

        //接收数据
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.valueOf(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.valueOf(status));

        //添加数据
        BRAND_SERVICE.add(brand);

        //重定向
        response.sendRedirect("/brand-demo/selectAllServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
