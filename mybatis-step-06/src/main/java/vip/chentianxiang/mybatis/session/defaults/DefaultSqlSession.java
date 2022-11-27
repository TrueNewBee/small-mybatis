package vip.chentianxiang.mybatis.session.defaults;

import vip.chentianxiang.mybatis.executor.Executor;
import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.Environment;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.Configuration;
import vip.chentianxiang.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 默认SqlSession实现类
 * @date 2022/04/01
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration,Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement,null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        // 调用执行器,返回查询结果
        List<T> list = executor.query(ms,parameter,Executor.NO_RESULT_HANDLER,ms.getBoundSql());
        return list.get(0);
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
