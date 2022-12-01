package vip.chentianxiang.mybatis.executor.statement;

import vip.chentianxiang.mybatis.executor.Executor;
import vip.chentianxiang.mybatis.executor.resultset.ResultSetHandler;
import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.Configuration;
import vip.chentianxiang.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @PROJECT_NAME: 语句处理器抽象基类
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:42
 * @DESCRIPTION: 语句处理器抽象基类
 */
public abstract class BaseStatementHandler implements StatementHandler{

    protected final Configuration configuration;
    protected final Executor executor;
    protected final MappedStatement mappedStatement;

    protected final Object parameterObject;
    protected final ResultSetHandler resultSetHandler;

    protected BoundSql boundsql;

    public BaseStatementHandler(Executor executor, MappedStatement mappedStatement,Object parameterObject, ResultHandler resultHandler,BoundSql boundSql){
        this.configuration = mappedStatement.getConfiguration();
        this.executor = executor;
        this.mappedStatement = mappedStatement;
        this.boundsql = boundSql;

        this.parameterObject = parameterObject;

        this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, boundSql);
    }

    // 准备阶段 实例化Statement
    @Override
    public Statement prepare(Connection connection) throws SQLException {
        Statement statement = null;
        try{
            // 实例化 Statement
            statement = instantiateStatement(connection);
            // 参数设置,可以被抽取,提供配置
            statement.setQueryTimeout(350);
            statement.setFetchSize(10000);
            return statement;
        }catch (Exception e){
            throw new RuntimeException("Error preparing statement. Cause: " + e,e);
        }
    }

    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;

}
