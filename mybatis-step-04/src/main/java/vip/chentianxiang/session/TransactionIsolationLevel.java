package vip.chentianxiang.session;

import java.sql.Connection;

/**
 * @PROJECT_NAME: 事务的隔离级别
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:54
 * @DESCRIPTION: 事务的隔离级别
 */

public enum TransactionIsolationLevel {

    //包括JDBC支持的5个级别
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
