package vip.chentianxiang.po;

import lombok.Data;

import java.util.Date;

/**
 * @PROJECT_NAME: demo
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:23
 * @DESCRIPTION:
 */
@Data
public class User {

    private Long id;
    private String userId;          // 用户ID
    private String userHead;        // 头像
    private Date createTime;        // 创建时间
    private Date updateTime;        // 更新时间
}
