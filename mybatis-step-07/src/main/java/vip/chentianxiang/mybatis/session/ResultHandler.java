package vip.chentianxiang.mybatis.session;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @PROJECT_NAME: 结果集处理器
 * @USER: TrueNewBee
 * @DATE: 2022/11/26 15:44
 * @DESCRIPTION: 结果集处理器
 */
public interface ResultHandler {
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;
}
