package vip.chentianxiang.io;
/**
 * @PROJECT_NAME: SQL 指令类型
 * @USER: TrueNewBee
 * @DATE: 2022-11-19 18:33:03
 * @DESCRIPTION:
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
