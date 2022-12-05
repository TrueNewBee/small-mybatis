package vip.chentianxiang.mybatis.reflection.invoker;

/**
 * @PROJECT_NAME: 调用者
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:48
 * @DESCRIPTION: 调用者
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
