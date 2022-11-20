package vip.chentianxiang.session;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 18:07
 * @DESCRIPTION: 工厂定义和实现
 *
 */
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
