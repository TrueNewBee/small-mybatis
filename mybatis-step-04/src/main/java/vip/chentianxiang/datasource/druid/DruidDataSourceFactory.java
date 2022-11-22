package vip.chentianxiang.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import vip.chentianxiang.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @PROJECT_NAME: Druid 数据源工厂
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:47
 * @DESCRIPTION: Druid 数据源工厂
 */
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    // 获取源对象
    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        return dataSource;
    }
}
