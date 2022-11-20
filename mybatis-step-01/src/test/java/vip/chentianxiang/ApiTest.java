package vip.chentianxiang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import vip.chentianxiang.binding.MapperProxyFactory;
import vip.chentianxiang.dao.IUserDao;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    // 测试代理接口
    @Test
    void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        // 把查询结果放到map中
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("vip.chentianxiang.dao.IUserDao.queryUserName", "模拟执行queryName");
        sqlSession.put("vip.chentianxiang.dao.IUserDao.queryUserAge", "模拟执行queryAge");
        // 实例化代理工厂
        IUserDao userDao = factory.newInstance(sqlSession);
        // 调用代理接口方法
        String res = userDao.queryUserName("10001");
        logger.info("测试结果:{}",res);

    }

    // 测试代理方法
    @Test
    void test_proxy_class(){
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("12");
        System.out.println("测试结果：" + result);

    }

}
