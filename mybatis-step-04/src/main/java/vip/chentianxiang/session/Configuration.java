package vip.chentianxiang.session;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.datasource.druid.DruidDataSourceFactory;
import vip.chentianxiang.mapping.Environment;
import vip.chentianxiang.mapping.MappedStatement;
import vip.chentianxiang.transaction.jdbc.JdbcTransactionFactory;
import vip.chentianxiang.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT_NAME: 配置项
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:22
 * @DESCRIPTION:
 */
public class Configuration {

    // 环境
    protected Environment environment;

    //映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句,存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration(){
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

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

    // 获取别名
    public TypeAliasRegistry getTypeAliasRegistry(){return typeAliasRegistry;}

    // 获取环境
    public Environment getEnvironment(){ return  environment;}

    // 添加环境
    public void setEnvironment(Environment environment){this.environment = environment;}

}
