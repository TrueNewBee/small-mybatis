package vip.chentianxiang.builder;

import lombok.Data;
import vip.chentianxiang.session.Configuration;
import vip.chentianxiang.type.TypeAliasRegistry;

/**
 * @PROJECT_NAME: 构建器的基类，建造者模式
 * @USER: TrueNewBee
 * @DATE: 2022/11/18 15:21
 * @DESCRIPTION:
 */
@Data
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;


    public BaseBuilder(Configuration configuration){
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration(){
        return configuration;
    }


}
