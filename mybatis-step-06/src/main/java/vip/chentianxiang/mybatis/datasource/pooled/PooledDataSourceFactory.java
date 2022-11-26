package vip.chentianxiang.mybatis.datasource.pooled;

import vip.chentianxiang.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @PROJECT_NAME: 有连接池的数据源工厂
 * @USER: TrueNewBee
 * @DATE: 2022/11/24 14:57
 * @DESCRIPTION: 有连接池的数据源工厂
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    @Override
    public DataSource getDataSource(){
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(properties.getProperty("drive"));
        pooledDataSource.setUrl(properties.getProperty("url"));
        pooledDataSource.setUsername(properties.getProperty("username"));
        pooledDataSource.setPassword(properties.getProperty("password"));
        return pooledDataSource;
    }
}
