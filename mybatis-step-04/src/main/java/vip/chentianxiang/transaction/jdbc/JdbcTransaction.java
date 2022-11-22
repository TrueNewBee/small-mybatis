package vip.chentianxiang.transaction.jdbc;

import vip.chentianxiang.session.TransactionIsolationLevel;
import vip.chentianxiang.transaction.Transaction;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PROJECT_NAME: MybatisDemo
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:54
 * @DESCRIPTION:
 */
public class JdbcTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;
    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;
    protected Boolean autoCommit;

    /**
     * 初始化参数
     * @param dataSource
     * @param level
     * @param autoCommit
     */
    public JdbcTransaction(DataSource dataSource,TransactionIsolationLevel level,Boolean autoCommit){
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }


    public JdbcTransaction(Connection connection){
        this.connection = connection;
    }

    // 建立链接,并返回connection对象
    @Override
    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(level.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    // 进行连接
    @Override
    public void commit() throws SQLException {
        if(connection !=null && !connection.getAutoCommit()){
            connection.commit();
        }
    }

    // 进行回滚
    @Override
    public void rollback() throws SQLException {
        if (connection != null && !connection.getAutoCommit()){
            connection.rollback();
        }
    }

    // 关闭连接
    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.getAutoCommit()){
            connection.close();
        }
    }
}
