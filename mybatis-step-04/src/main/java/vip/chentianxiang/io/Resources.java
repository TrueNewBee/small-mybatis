package vip.chentianxiang.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @PROJECT_NAME: 通过类加载器获得resource的辅助类
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:21
 * @DESCRIPTION:
 */
public class Resources {


    public static Reader getResourceAsReader(String resource) throws IOException{
        return new InputStreamReader(getResourceAsStream(resource));
    }

    // 加载流
    public static InputStream getResourceAsStream  (String resource) throws IOException{
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader classLoader : classLoaders){
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if( null != inputStream){
                return inputStream;
            }
        }
        throw new IOException("Could not find resource" + resource);
    }

    // 加载类
    private static ClassLoader[] getClassLoaders(){
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()
        };
    }

    /**
     * Loads a  class
     * @param className  - the class to fetch
     * @return The loaded class
     * @throws ClassNotFoundException  If the class cannot be found (duh!)
     */
   public static Class<?> classForName(String className) throws ClassNotFoundException{
       return Class.forName(className);
   }

}
