package vip.chentianxiang.session.defaults;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.session.SqlSession;
import vip.chentianxiang.session.SqlSessionFactory;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:05
 * @DESCRIPTION:
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory( MapperRegistry mapperRegistry ){
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
