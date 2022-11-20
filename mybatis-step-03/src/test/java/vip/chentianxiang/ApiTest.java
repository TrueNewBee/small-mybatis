package vip.chentianxiang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import vip.chentianxiang.binding.MapperProxyFactory;
import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.dao.IUserDao;
import vip.chentianxiang.io.Resources;
import vip.chentianxiang.session.SqlSession;
import vip.chentianxiang.session.SqlSessionFactory;
import vip.chentianxiang.session.SqlSessionFactoryBuilder;
import vip.chentianxiang.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    // 测试代理接口
    @Test
    void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);

    }


}
