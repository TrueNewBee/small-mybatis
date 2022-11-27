package vip.chentianxiang.mybatis.executor;

import vip.chentianxiang.mybatis.mapping.BoundSql;
import vip.chentianxiang.mybatis.mapping.MappedStatement;
import vip.chentianxiang.mybatis.session.ResultHandler;
import vip.chentianxiang.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @PROJECT_NAME: 执行器
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:41
 * @DESCRIPTION: 执行器
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    // 查询
    <E>List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);
    // 事务
    Transaction getTransaction();
    // 提交
    void commit(boolean required) throws SQLException;
    // 回滚
    void rollback(boolean required) throws SQLException;
    // 关闭
    void close(boolean forceRollback);
}
