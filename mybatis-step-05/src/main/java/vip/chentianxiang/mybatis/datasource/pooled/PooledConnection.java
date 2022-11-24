package vip.chentianxiang.mybatis.datasource.pooled;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @PROJECT_NAME: 池化代理的链接
 * @USER: TrueNewBee
 * @DATE: 2022/11/24 14:57
 * @DESCRIPTION: 池化代理的链接
 */
@Data
public class PooledConnection implements InvocationHandler {

    private static final String CLOSE ="close";
    private static final  Class<?>[] IFACES = new Class<?>[]{Connection.class};

    private int hashCode = 0;
    private PooledDataSource dataSource;

    // 真实的连接
    private Connection realConnection;
    // 代理的连接
    private Connection proxyConnection;

    private long checkoutTimestamp;
    private long createdTimestamp;
    private long lastUsedTimestamp;
    private long connectionTypeCode;
    private boolean valid;

    public PooledConnection(Connection connection, PooledDataSource dataSource){
        this.hashCode = connection.hashCode();
        this.realConnection = connection;
        this.dataSource = dataSource;
        this.createdTimestamp = System.currentTimeMillis();
        this.lastUsedTimestamp = System.currentTimeMillis();
        this.valid = true;
        this.proxyConnection = (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(),IFACES,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        // 如果是调用CLOSE 关闭连接方法,则将连接加入连接池中,并返回null
        if (CLOSE.hashCode() == methodName.hashCode() && CLOSE.equals(methodName)){
            dataSource.pushConnection(this);
            return null;
        }else {
            if(!Object.class.equals(method.getDeclaringClass())){
                // 除了toString()方法,其他方法调用之前要检查connection是否还是合法的,不合法爆出SQlException
                checkConnection();
            }
            // 其他方法交给connection去调用
            return method.invoke(realConnection, args);
        }
        return null;
    }

    private void checkConnection() throws SQLException{
        if (!valid){
            throw new SQLException("Error accessing PooledConnection. Connection is invalid");
        }
    }
}
