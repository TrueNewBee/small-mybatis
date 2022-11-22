package vip.chentianxiang.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @PROJECT_NAME: 类型别名注册机
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:55
 * @DESCRIPTION: 类型别名注册机
 */
public class TypeAliasRegistry {

    private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<>();

    public TypeAliasRegistry(){
        // 构造函数里注册系统内置的类型别名
        registerAlias("String",String.class);

        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    // 注册别名
    public void registerAlias(String alias, Class<?> value){
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIASES.put(key,value);
    }

    public <T>  Class<T> resolveAlias(String string){
        String key = string.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIASES.get(key);
    }

}
