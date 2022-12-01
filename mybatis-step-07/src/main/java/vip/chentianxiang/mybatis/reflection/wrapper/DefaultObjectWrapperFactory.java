package vip.chentianxiang.mybatis.reflection.wrapper;

import vip.chentianxiang.mybatis.reflection.MetaObject;

/**
 * @PROJECT_NAME: MybatisDemo
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:50
 * @DESCRIPTION:
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
