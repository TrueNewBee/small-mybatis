package vip.chentianxiang.binding;

import vip.chentianxiang.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/16 23:13
 * @DESCRIPTION: 映射器代理类
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static  final long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    // 被代理的类
    private final Class<T> mapperInterface;


    public MapperProxy( SqlSession sqlSession,Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    // 重写代理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
               return sqlSession.selectOne(method.getName(), args);
        }
    }
}
