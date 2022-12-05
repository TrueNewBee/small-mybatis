package vip.chentianxiang.mybatis.test;

import vip.chentianxiang.mybatis.builder.xml.XMLConfigBuilder;
import vip.chentianxiang.mybatis.datasource.pooled.PooledDataSource;
import vip.chentianxiang.mybatis.io.Resources;
import vip.chentianxiang.mybatis.session.Configuration;
import vip.chentianxiang.mybatis.session.SqlSession;
import vip.chentianxiang.mybatis.session.SqlSessionFactory;
import vip.chentianxiang.mybatis.session.SqlSessionFactoryBuilder;
import vip.chentianxiang.mybatis.session.defaults.DefaultSqlSession;
import vip.chentianxiang.mybatis.test.dao.IUserDao;
import vip.chentianxiang.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @date 2022/3/26
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

}