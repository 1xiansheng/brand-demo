package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     *
     * @return
     */
    public List<Brand> selectAll() {
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }


    /**
     * 添加数据
     */
    public void add(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.add(brand);

        sqlSession.commit();

        sqlSession.close();
    }


    /**
     * 查询id
     */
    public Brand selectById(int id) {
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();
        return brand;
    }


    /**
     * 修改数据
     */
    public void update(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.update(brand);

        sqlSession.commit();

        sqlSession.close();
    }


    public void deleteById(int id) {
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();
    }

}
