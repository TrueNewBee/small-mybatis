package vip.chentianxiang.mybatis.executor.statement;

import vip.chentianxiang.mybatis.executor.Executor;
import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @PROJECT_NAME: 预处理语句处理器（PREPARED）
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:42
 * @DESCRIPTION: 预处理语句处理器（PREPARED）
 */
public class PreparedStatementHandler extends BaseStatementHandler{

    public PreparedStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        String sql = boundsql.getSql();
        return connection.prepareStatement(sql) ;
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.setLong(1,Long.parseLong(((Object[]) parameterObject)[0].toString()));
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        return resultSetHandler.<E>handleResultSets(ps);
    }
}
