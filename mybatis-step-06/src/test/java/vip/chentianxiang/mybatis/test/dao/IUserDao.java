package vip.chentianxiang.mybatis.test.dao;

import vip.chentianxiang.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
