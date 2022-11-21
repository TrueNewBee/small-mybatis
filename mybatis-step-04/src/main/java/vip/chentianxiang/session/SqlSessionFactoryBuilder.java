package vip.chentianxiang.session;

import vip.chentianxiang.builder.xml.XMLConfigBuilder;
import vip.chentianxiang.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:23
 * @DESCRIPTION: 构建SqlSessionFactory的工厂
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        // 解析XMl
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        // 返回一个 加载配置后的 DefaultSqlSessionFactory 对象用于后续操作
        return build (xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config ){
        return new DefaultSqlSessionFactory(config);
    }

}
