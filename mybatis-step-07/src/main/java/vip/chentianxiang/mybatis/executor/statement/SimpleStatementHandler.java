package vip.chentianxiang.mybatis.executor.statement;

import vip.chentianxiang.mybatis.executor.Executor;
import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @PROJECT_NAME: 简单语句处理器（STATEMENT）
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:42
 * @DESCRIPTION: 简单语句处理器（STATEMENT）
 */
public class SimpleStatementHandler extends BaseStatementHandler {
    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement() ;
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundsql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }
}
