package vip.chentianxiang.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PROJECT_NAME: 事务的接口
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:53
 * @DESCRIPTION:   事务的接口
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void  commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
