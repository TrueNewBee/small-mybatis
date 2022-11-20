package vip.chentianxiang.session.defaults;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.session.SqlSession;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:04
 * @DESCRIPTION:
 * 通过 DefaultSqlSession 实现类对 SqlSession 接口进行实现。
 * getMapper 方法中获取映射器对象是通过 MapperRegistry 类进行获取的，后续这部分会被配置类进行替换。
 */
public class DefaultSqlSession implements SqlSession {

    // 映射器注册机
    private MapperRegistry mapperRegistry;

    // 构造方法
    public DefaultSqlSession(MapperRegistry mapperRegistry){
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了!" + "方法: " + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T)("你被代理了!" + "方法: " + statement+" 入参: " + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
