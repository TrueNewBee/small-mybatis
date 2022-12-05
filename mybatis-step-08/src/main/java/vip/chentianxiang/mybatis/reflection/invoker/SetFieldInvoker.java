package vip.chentianxiang.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 * @PROJECT_NAME: setter 调用者
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:48
 * @DESCRIPTION: setter 调用者
 * setter 方法的调用者处理，因为set只是设置值，所以这里就只返回一个 null 就可以了
 */
public class SetFieldInvoker implements Invoker {

    private Field field;

    public SetFieldInvoker(Field field){ this.field = field;}

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target,args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
