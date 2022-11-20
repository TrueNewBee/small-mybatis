package vip.chentianxiang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import vip.chentianxiang.binding.MapperProxyFactory;
import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.dao.IUserDao;
import vip.chentianxiang.session.SqlSession;
import vip.chentianxiang.session.defaults.DefaultSqlSessionFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    // 测试代理接口
    @Test
    void test_MapperProxyFactory() {
        // 1.注册 Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("vip.chentianxiang.dao");

        // 2.从 SqlSession 工厂汇总获取 Session
        DefaultSqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
        SqlSession sqlSession = sessionFactory.openSession();

        // 3. 获取映射对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10086");
        logger.info("测试结果: {}",res);

    }


}
