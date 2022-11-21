package vip.chentianxiang.session;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.mapping.MappedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT_NAME: 配置项
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:22
 * @DESCRIPTION:
 */
public class Configuration {
    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句,存在Map里
     */
    protected Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 扫描包 添加mappers
    public  void addMappers(String packageName){
        mapperRegistry.addMappers(packageName);
    }

    // 添加单个Mapper接口
    public <T> void  addMapper(Class<T> type){
        mapperRegistry.addMapper(type);
    }

    // 获取mapper
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type){
        return mapperRegistry.hashMapper(type);
    }

    // 添加映射语句
    public void addMappedStatement(MappedStatement ms){
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id){
        return mappedStatements.get(id);
    }











}
