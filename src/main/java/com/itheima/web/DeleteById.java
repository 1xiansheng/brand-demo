package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteById extends HttpServlet {
    private final BrandService BRAND_SERVICE = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收id
        String id = request.getParameter("id");
        //2.调用service删除
        BRAND_SERVICE.deleteById(Integer.parseInt(id));
        //3. 存储到request中
        //request.setAttribute("id",id);

        //4.转发到update.jsp
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
