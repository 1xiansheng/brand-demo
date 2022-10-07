package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    private final BrandService BRAND_SERVICE = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post请求乱码
        request.setCharacterEncoding("utf-8");

        //接收数据
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        //封装对象
        Brand brand = new Brand();
        brand.setId(Integer.valueOf(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.valueOf(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.valueOf(status));

        //添加数据
        BRAND_SERVICE.update(brand);

        //重定向
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
