package vip.chentianxiang.mybatis.executor;

import vip.chentianxiang.mybatis.executor.statement.StatementHandler;
import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.Configuration;
import vip.chentianxiang.mybatis.session.ResultHandler;
import vip.chentianxiang.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @PROJECT_NAME: 简单执行器
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:43
 * @DESCRIPTION: 简单执行器
 */
public class SimpleExecutor extends BaseExecutor{
    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try{
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler =  configuration.newStatementHandler(this,ms,parameter,resultHandler,boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt  = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt, resultHandler);
        }catch (SQLException e){
            e.printStackTrace();
            return  null;
        }
    }
}
