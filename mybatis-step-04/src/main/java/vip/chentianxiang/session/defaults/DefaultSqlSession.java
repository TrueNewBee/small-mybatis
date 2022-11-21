package vip.chentianxiang.session.defaults;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.mapping.MappedStatement;
import vip.chentianxiang.session.Configuration;
import vip.chentianxiang.session.SqlSession;

/** 开始从配置类中读取信息 不用从注册类了
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:04
 * @DESCRIPTION:
 * 通过 DefaultSqlSession 实现类对 SqlSession 接口进行实现。
 * getMapper 方法中获取映射器对象是通过 MapperRegistry 类进行获取的，后续这部分会被配置类进行替换。
 */
public class DefaultSqlSession implements SqlSession {

    // 从配置类中读取
    private Configuration configuration;

    // 构造方法
    public DefaultSqlSession( Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了!" + "方法: " + statement);
    }

    @Override
    // bug +mappedStatement.getSql()   从xml中未获取到sql这个语句,其他完美 2022-11-19 19:15:47
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T)("你被代理了!" + "\n方法: " + statement+"\n 入参: " + parameter+"\n待执行SQL");
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
