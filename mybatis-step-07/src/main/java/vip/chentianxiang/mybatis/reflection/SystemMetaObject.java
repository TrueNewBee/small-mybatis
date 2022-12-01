package vip.chentianxiang.mybatis.reflection;

import vip.chentianxiang.mybatis.reflection.factory.DefaultObjectFactory;
import vip.chentianxiang.mybatis.reflection.factory.ObjectFactory;
import vip.chentianxiang.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import vip.chentianxiang.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @PROJECT_NAME: 一些系统级别的元对象
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:47
 * @DESCRIPTION: 一些系统级别的元对象
 */
public class SystemMetaObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);


    private SystemMetaObject(){
        // Prevent Instantiation of Static Class
    }

    /**
     * 空对象
     */
    private static class NullObject{
    }

    public static MetaObject forObject(Object object){
        return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
    }

}
