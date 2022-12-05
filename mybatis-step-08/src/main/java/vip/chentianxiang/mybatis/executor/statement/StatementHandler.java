package vip.chentianxiang.mybatis.executor.statement;

import vip.chentianxiang.mybatis.session.ResultHandler;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @PROJECT_NAME: 语句处理器
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:43
 * @DESCRIPTION: 语句处理器
 */
public interface StatementHandler {

    // 准备语句
    Statement prepare(Connection connection) throws SQLException;

    // 参数化
    void parameterize(Statement statement) throws SQLException;

    // 执行查询
    <E>List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;

}
