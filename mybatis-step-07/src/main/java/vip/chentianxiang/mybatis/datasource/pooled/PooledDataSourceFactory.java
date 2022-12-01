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

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
