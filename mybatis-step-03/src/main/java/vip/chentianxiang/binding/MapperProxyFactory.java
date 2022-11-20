package vip.chentianxiang.binding;

import vip.chentianxiang.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/16 23:16
 * @DESCRIPTION: 映射器代理工厂
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface= mapperInterface;
    }

    // 实例化代理接口
    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
