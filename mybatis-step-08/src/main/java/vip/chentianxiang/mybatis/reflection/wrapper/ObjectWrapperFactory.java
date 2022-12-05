package vip.chentianxiang.mybatis.reflection.wrapper;

import vip.chentianxiang.mybatis.reflection.MetaObject;

/**
 * @PROJECT_NAME: 对象包装工厂
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:51
 * @DESCRIPTION: 对象包装工厂
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器 getWrapperFor
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
