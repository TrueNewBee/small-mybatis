package vip.chentianxiang.transaction;

import cn.hutool.db.transaction.TransactionLevel;
import vip.chentianxiang.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @PROJECT_NAME: 事务工厂
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:53
 * @DESCRIPTION: 事务工厂
 */
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     * @param conn Existing database connection
     * @return  Transaction
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建 Transaction
     * @param dataSource DataSource to take the connection from
     * @param level Desired isolation level
     * @param autoCommit    Desired autocommit
     * @return Transaction
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
