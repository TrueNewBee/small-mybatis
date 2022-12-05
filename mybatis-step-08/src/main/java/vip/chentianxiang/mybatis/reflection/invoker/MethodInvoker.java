package vip.chentianxiang.mybatis.reflection.invoker;

import java.lang.reflect.Method;

/**
 * @PROJECT_NAME: 方法调用者
 * @USER: TrueNewBee
 * @DATE: 2022/11/29 16:48
 * @DESCRIPTION: 方法调用者
 * 提供方法反射调用处理，构造函数会传入对应的方法类型。
 */
public class MethodInvoker implements Invoker  {

    private Class<?> type;
    private Method method;

    public MethodInvoker(Method method){
        this.method = method;

        // 如果只有一个参数,返回参数类型,否则返回 return 类型
        if (method.getParameterTypes().length ==1){
            type = method.getParameterTypes()[0];
        }else {
            type = method.getReturnType();
        }
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return method.invoke(target,args);
    }

    @Override
    public Class<?> getType() {
        return type;
    }
}
