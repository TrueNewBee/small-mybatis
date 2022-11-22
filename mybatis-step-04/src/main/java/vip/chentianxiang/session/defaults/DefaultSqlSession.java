package vip.chentianxiang.session.defaults;

import vip.chentianxiang.binding.MapperRegistry;
import vip.chentianxiang.mapping.BoundSql;
import vip.chentianxiang.mapping.Environment;
import vip.chentianxiang.mapping.MappedStatement;
import vip.chentianxiang.session.Configuration;
import vip.chentianxiang.session.SqlSession;

import javax.xml.crypto.Data;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 开始从配置类中读取信息 不用从注册类了
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:04
 * @DESCRIPTION:
 * 通过 DefaultSqlSession 实现类对 SqlSession 接口进行实现。
 * getMapper 方法中获取映射器对象是通过 MapperRegistry 类进行获取的，后续这部分会被配置类进行替换。
 */
public class DefaultSqlSession implements SqlSession {

    // 从配置类中读取
    private Configuration configuration;

    // 构造方法
    public DefaultSqlSession( Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了!" + "方法: " + statement);
    }

    // 执行SQL
    @Override
    public <T> T selectOne(String statement, Object parameter) {
        try{
            // 获取SQL映射对象
            MappedStatement mappedStatement = configuration.getMappedStatement(statement);
            // 获取环境
            Environment environment = configuration.getEnvironment();
            // 创建链接
            Connection connection = environment.getDataSource().getConnection();
            // 获取sql绑定对象
            BoundSql boundSql = mappedStatement.getBoundSql();
            PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSql());
            preparedStatement.setLong(1,Long.parseLong(((Object[])parameter)[0].toString()));
            // 执行SQL映射语句
            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> objList = resultSet2Obj(resultSet, Class.forName(boundSql.getSql()));
            return objList.get(0);

       }catch (Exception e) {
           e.printStackTrace();
           return null;
       }

    }

    // 把查询后的结果封装到list中  2022-11-21 23:28:53 明天继续
    private <T> List<T> resultSet2Obj(ResultSet resultSet,Class<?> cLass){
        ArrayList<T> list = new ArrayList<>();
        try{
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // 每次遍历行值
            while (resultSet.next()){
                T obj = (T)cLass.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if (value instanceof Timestamp){
                        method = cLass.getMethod(setMethod, Data.class);
                    }else {
                        method = cLass.getMethod(setMethod, value.getClass());
                    }
                    method.invoke(obj, value);
                }
                list.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
