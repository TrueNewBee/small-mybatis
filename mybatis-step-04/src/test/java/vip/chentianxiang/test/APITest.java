package vip.chentianxiang.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vip.chentianxiang.builder.xml.XMLConfigBuilder;
import vip.chentianxiang.io.Resources;
import vip.chentianxiang.session.Configuration;
import vip.chentianxiang.session.SqlSession;
import vip.chentianxiang.session.SqlSessionFactory;
import vip.chentianxiang.session.SqlSessionFactoryBuilder;
import vip.chentianxiang.session.defaults.DefaultSqlSession;
import vip.chentianxiang.test.dao.IUserDao;
import vip.chentianxiang.test.po.User;

import java.io.IOException;
import java.io.Reader;

/**
 * @PROJECT_NAME: MybatisDemo
 * @USER: TrueNewBee
 * @DATE: 2022/11/21 14:30
 * @DESCRIPTION:
 */
public class APITest {
    private Logger logger = LoggerFactory.getLogger(APITest.class);

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

    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("vip.chentianxiang.test.dao.IUserDao.queryUserInfoById", req);
        // logger.info("测试结果：{}", JSON.toJSONString(res));
    }
}
