package vip.chentianxiang.mybatis.reflection.invoker;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @PROJECT_NAME: getter 调用者
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:48
 * @DESCRIPTION: getter 调用者
 * getter 方法的调用者处理，因为get是有返回值的，所以直接对 Field 字段操作完后直接返回结果
 */
public class GetFieldInvoker implements Invoker{

    private Field field;

    public GetFieldInvoker(Field field){
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
