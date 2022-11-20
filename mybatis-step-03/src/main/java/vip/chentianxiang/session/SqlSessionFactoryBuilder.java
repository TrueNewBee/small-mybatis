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
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build (xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config ){
        return new DefaultSqlSessionFactory(config);
    }

}
