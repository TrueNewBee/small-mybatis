package vip.chentianxiang.mapping;

import lombok.Data;
import vip.chentianxiang.transaction.TransactionFactory;

import javax.sql.DataSource;

/**
 * @PROJECT_NAME: 环境
 * @USER: TrueNewBee
 * @DATE: 2022/11/20 19:49
 * @DESCRIPTION: 环境
 */
@Data
public class Environment {

    // 环境
    private final String id;
    // 事务工厂
    private final TransactionFactory transactionFactory;
    // 数据源
    private final DataSource dataSource;

    public Environment(String id,TransactionFactory transactionFactory,DataSource dataSource){
        this.id = id;
        this.transactionFactory = transactionFactory;
        this.dataSource = dataSource;
    }

    public static class Builder {

        private String id;
        private TransactionFactory transactionFactory;
        private DataSource dataSource;

        public Builder(String id){
            this.id = id;
        }

        // 初始化事务工厂
        public Builder transactionFactory(TransactionFactory transactionFactory){
            this.transactionFactory = transactionFactory;
            return this;
        }

        // 初始化数据源
        public Builder dataSource(DataSource dataSource){
            this.dataSource = dataSource;
            return  this;
        }

        public String id(){
            return this.id;
        }

        // 创建环境对象
        public Environment build(){
            return new Environment(this.id, this.transactionFactory, this.dataSource);
        }
    }

}
