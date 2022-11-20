package vip.chentianxiang.binding;

import cn.hutool.core.lang.ClassScanner;
import vip.chentianxiang.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:04
 * @DESCRIPTION: 映射器注册机
 */
public class MapperRegistry {
    /**
     * 将已添加的映射器代理加入到HashMap中
     * MapperRegistry 映射器注册类的核心主要在于提供了 ClassScanner.scanPackage 扫描包路径，
     * 调用 addMapper 方法，给接口类创建 MapperProxyFactory 映射器代理类，并写入到 knownMappers 的 HashMap 缓存中。
     * 另外就是这个类也提供了对应的 getMapper 获取映射器代理类的方法，
     * 其实这步就包装了我们上一章节手动操作实例化的过程，更加方便在 DefaultSqlSession 中获取 Mapper 时进行使用。
     */

    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type , SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(null == mapperProxyFactory){
            throw new RuntimeException("type" + type + "is not known to the MapperRegistry.");
        }
        try{
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Caues:" + e, e);
        }
    }

    // 添加代理
    public <T> void addMapper(Class<T> type){
        /* Mapper 必须是接口才会注册*/
        if (type.isInterface()){
            if(hasMapper(type)){
                // 如果重复添加,报错
                throw new RuntimeException("Type" + type + "is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    // 判断是否重复
    public <T> boolean hasMapper(Class<T> type){
        return knownMappers.containsKey(type);
    }

    // 批量注册
    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet){
            addMapper(mapperClass);
        }
    }
}
