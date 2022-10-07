package com.itheima;

import com.itheima.pojo.Brand;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //3. 获取IoC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //4. 获取bean
        Brand brand = (Brand) ctx.getBean("brand");

        brand.setId(5);
        System.out.println(brand.getId());
    }
}
