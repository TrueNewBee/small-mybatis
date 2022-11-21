package vip.chentianxiang.session.defaults;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.session.Configuration;
import vip.chentianxiang.session.SqlSession;
import vip.chentianxiang.session.SqlSessionFactory;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:05
 * @DESCRIPTION:
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory( Configuration configuration ){
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
