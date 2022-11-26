package vip.chentianxiang.mybatis.datasource.unpooled;

import vip.chentianxiang.mybatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @PROJECT_NAME: 无池化数据源实现
 * @USER: TrueNewBee
 * @DATE: 2022/11/24 14:58
 * @DESCRIPTION: 无池化数据源实现
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected Properties properties;
    @Override
    public void setProperties(Properties props) {
        this.properties = props;
    }

    @Override
    public DataSource getDataSource() {
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setDriver(properties.getProperty("driver"));
        unpooledDataSource.setUrl(properties.getProperty("url"));
        unpooledDataSource.setUsername(properties.getProperty("username"));
        unpooledDataSource.setPassword(properties.getProperty("password"));
        return unpooledDataSource;
    }
}
