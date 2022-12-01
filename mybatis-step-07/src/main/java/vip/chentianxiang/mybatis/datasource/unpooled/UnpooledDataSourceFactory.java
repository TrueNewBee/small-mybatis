package vip.chentianxiang.mybatis.datasource.unpooled;

import vip.chentianxiang.mybatis.datasource.DataSourceFactory;
import vip.chentianxiang.mybatis.reflection.MetaObject;
import vip.chentianxiang.mybatis.reflection.SystemMetaObject;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @PROJECT_NAME: 无池化数据源实现
 * @USER: TrueNewBee
 * @DATE: 2022/11/24 14:58
 * @DESCRIPTION: 无池化数据源实现
 * // 2022-12-1 22:59:26
 * 通过反射拿到相应的数据
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected DataSource dataSource;

    public UnpooledDataSourceFactory(){
        this.dataSource = new UnpooledDataSource();
    }

    @Override
    public void setProperties(Properties props) {
        MetaObject metaObject = SystemMetaObject.forObject(dataSource);
        for (Object key : props.keySet()) {
            String propertyName = (String) key;
            if (metaObject.hasSetter(propertyName)){
                String value = (String) props.get(propertyName);
                Object convertedValue = convertValue(metaObject,propertyName,value);
                metaObject.setValue(propertyName,convertedValue);
            }
        }

    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 根据 setter的类型,将配置文件中的值强转成相应的类型
     */
    private Object convertValue(MetaObject metaObject, String propertyName, String value){
        Object convertedValue = value;
        Class<?> targetType = metaObject.getSetterType(propertyName);
        if (targetType == Integer.class || targetType == int.class){
            convertedValue = Integer.valueOf(value);
        } else if (targetType == Long.class || targetType == long.class){
            convertedValue = Long.valueOf(value);
        } else if (targetType == Boolean.class || targetType == boolean.class){
            convertedValue = Boolean.valueOf(value);
        }
        return convertedValue;
    }


}
