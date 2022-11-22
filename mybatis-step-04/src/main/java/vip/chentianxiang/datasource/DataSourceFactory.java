package vip.chentianxiang.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @PROJECT_NAME: 数据源工厂
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:46
 * @DESCRIPTION: 数据源工厂
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();
}
