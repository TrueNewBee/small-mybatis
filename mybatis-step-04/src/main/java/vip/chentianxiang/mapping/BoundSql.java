package vip.chentianxiang.mapping;

import lombok.Data;

import java.util.Map;

/**
 * @PROJECT_NAME: sql绑定
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:49
 * @DESCRIPTION: 绑定的SQL,是从SqlSource而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 */
@Data
public class BoundSql {

    private String sql;
    private Map<Integer,String> parameterMapping;
    private String parameterType;
    private String resultType;

    public BoundSql(String sql,Map<Integer,String> parameterMapping,String parameterType,String resultType){
        this.sql = sql;
        this.parameterMapping = parameterMapping;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

}
