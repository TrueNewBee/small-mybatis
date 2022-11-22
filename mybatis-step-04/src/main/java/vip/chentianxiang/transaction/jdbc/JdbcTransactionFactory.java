package vip.chentianxiang.transaction.jdbc;

import cn.hutool.db.transaction.TransactionLevel;
import vip.chentianxiang.session.TransactionIsolationLevel;
import vip.chentianxiang.transaction.Transaction;
import vip.chentianxiang.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @PROJECT_NAME: MybatisDemo
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:54
 * @DESCRIPTION:
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }


    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }



}
