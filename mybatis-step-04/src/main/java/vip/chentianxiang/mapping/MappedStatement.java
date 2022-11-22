package vip.chentianxiang.mapping;

import lombok.Data;
import vip.chentianxiang.io.SqlCommandType;
import vip.chentianxiang.session.Configuration;

import java.util.Map;

/**
 * @PROJECT_NAME: 映射语句类
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:22
 * @DESCRIPTION:
 */
@Data
public class MappedStatement {

    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;
    private BoundSql boundSql;

    MappedStatement() {
        // constructor disabled
    }

    /**
     * 建造者
     */
    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.boundSql = boundSql;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }
}
