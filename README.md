### 手写Mybatis

#### 0. 初衷:

``` java
重造Mybatis轮子,对Mybatis源码以及其中设计模式有更深层的理解  
越努力,越幸运~
```



#### 1.创建简单的映射器代理工厂

**1.1代理类设计**

![图 2-1 代理类设计](https://bugstack.cn/images/article/spring/mybatis-220327-01.png)

**1.2 Mybatis 映射器代理类关系**

![如图 2-2 代理类关系图](https://bugstack.cn/images/article/spring/mybatis-220327-02.png)



#### 2.实现映射器的注册和使用

**2.1 **映射器的注册和使用

![图 3-1 ](https://bugstack.cn/images/article/spring/mybatis-220404-01.png)

**2.2 映射器标准定义实现关系 **

![图 3-2 映射器标准定义实现关系](https://bugstack.cn/images/article/spring/mybatis-220404-02.png)



#### 3. Mapper XML的解析和注册使用

**3.1 目标(ORM 框架核心流程)**

![图 4-1 ORM 框架核心流程](https://bugstack.cn/images/article/spring/mybatis-220409-01.png)

**3.2 XML 文件解析注册处理 **

![图 4-2 XML 文件解析注册处理](https://bugstack.cn/images/article/spring/mybatis-220409-02.png)

**3.3 XML 解析和注册类实现关**

![图 4-2 XML 解析和注册类实现关系](https://bugstack.cn/images/article/spring/mybatis-220409-03.png)



#### 4. 数据源的解析、创建和使用

**4.1 数据源的解析和使用**

![图 5-1 数据源的解析和使用](https://bugstack.cn/images/article/spring/mybatis-220414-01.png)

**4.2 数据源的解析和使用核心类关系**

![图 5-2 数据源的解析和使用核心类关系](https://bugstack.cn/images/article/spring/mybatis-220414-02.png)