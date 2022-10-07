package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import com.itheima.web.SelectByIdServlet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     *
     * @return
     */
    public User login(String username, String password) {

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        User user = mapper.select(username, password);

        sqlSession.close();
        return user;
    }


    /**
     * 注册方法
     *
     * @return
     */
    public boolean register(User user) {

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 判断用户是否存在
        User U = mapper.selectByUsername(user.getUsername());

        if (U == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return U == null;
    }
}
