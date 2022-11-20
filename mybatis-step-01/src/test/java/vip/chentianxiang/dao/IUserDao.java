package vip.chentianxiang.dao;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/17 15:39
 * @DESCRIPTION: DAO 接口
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
