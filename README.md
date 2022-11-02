

open-tag 平台
===============

项目介绍
-----------------------------------
为了方便对业务数据集进行打标签流程

技术支持
-----------------------------------

52215903006@stu.ecnu.edu.cn


技术文档
-----------------------------------

- 开发文档：  [主项目文档](http://doc.jeecg.com) 

后台目录结构
-----------------------------------
```
项目结构
├─jeecg-boot-parent（父POM： 项目依赖、modules组织）
│  ├─jeecg-boot-base-core（共通模块： 工具类、config、权限、查询过滤器、注解等）
│  ├─jeecg-module-demo    open-tag业务代码
│  ├─jeecg-module-system  System系统管理目录
│  │  ├─jeecg-system-biz    System系统管理权限等功能
│  │  ├─jeecg-system-start  System单体启动项目(8080）
│  │  ├─jeecg-system-api    System系统管理模块对外api
│  │  │  ├─jeecg-system-cloud-api   System模块对外提供的微服务接口
│  │  │  ├─jeecg-system-local-api   System模块对外提供的单体接口
│  ├─jeecg-server-cloud           --微服务模块
     ├─jeecg-cloud-gateway       --微服务网关模块(9999)
     ├─jeecg-cloud-nacos       --Nacos服务模块(8848)
     ├─jeecg-system-cloud-start  --System微服务启动项目(7001)
     ├─jeecg-demo-cloud-start    --Demo微服务启动项目(7002)
     ├─jeecg-visual
        ├─jeecg-cloud-monitor       --微服务监控模块 (9111)
        ├─jeecg-cloud-xxljob        --微服务xxljob定时任务服务端 (9080)
        ├─jeecg-cloud-sentinel     --sentinel服务端 (9000)
        ├─jeecg-cloud-test           -- 微服务测试示例（各种例子）
           ├─jeecg-cloud-test-more         -- 微服务测试示例（feign、熔断降级、xxljob、分布式锁）
           ├─jeecg-cloud-test-rabbitmq     -- 微服务测试示例（rabbitmq）
           ├─jeecg-cloud-test-seata          -- 微服务测试示例（seata分布式事务）
           ├─jeecg-cloud-test-shardingsphere    -- 微服务测试示例（分库分表）
```
 
技术架构：
-----------------------------------
#### 开发环境

- 语言：Java 8+ (小于17)

- IDE(JAVA)： IDEA (必须安装lombok插件 )

- IDE(前端)： Vscode、WebStorm、IDEA

- 依赖管理：Maven

- 缓存：Redis

- 数据库脚本：MySQL5.7+  &  Oracle 11g & Sqlserver2017（其他数据库，[需要自己转](https://my.oschina.net/jeecg/blog/4905722)）


#### 后端

- 基础框架：Spring Boot 2.6.6

- 微服务框架： Spring Cloud Alibaba 2021.0.1.0

- 持久层框架：MybatisPlus 3.5.1

- 报表工具： JimuReport 1.5.2

- 安全框架：Apache Shiro 1.8.0，Jwt 3.11.0

- 微服务技术栈：Spring Cloud Alibaba、Nacos、Gateway、Sentinel、Skywalking

- 数据库连接池：阿里巴巴Druid 1.1.22

- 日志打印：logback

- 其他：autopoi, fastjson，poi，Swagger-ui，quartz, lombok（简化代码）等。


#### 前端

- Vue：`Vue2.6+@vue/cli+AntDesignVue+Viser-vue+Vuex等`  [详细查看](https://github.com/X-lab2017/open-tag-web)

#### 支持库

|  数据库   |  支持   |
| --- | --- |
|   MySQL   |  √   |
|  Oracle11g   |  √   |
|  Sqlserver2017   |  √   |
|   PostgreSQL   |  √   |
|   MariaDB   |  √   |
|   达梦、人大金仓   |  √   |


系统效果
----
##### 大屏模板
![输入图片说明](https://static.oschina.net/uploads/img/201912/25133248_Ag1C.jpg "在这里输入图片标题")

![输入图片说明](https://static.oschina.net/uploads/img/201912/25133301_k9Kc.jpg "在这里输入图片标题")

##### PC端
![输入图片说明](https://static.oschina.net/uploads/img/201904/14155402_AmlV.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160657_cHwb.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160813_KmXS.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160935_Nibs.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14161004_bxQ4.png "在这里输入图片标题")


##### 在线接口文档
![输入图片说明](https://static.oschina.net/uploads/img/201908/27095258_M2Xq.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160957_hN3X.png "在这里输入图片标题")


##### 报表
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160828_pkFr.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160834_Lo23.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160842_QK7B.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160849_GBm5.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160858_6RAM.png "在这里输入图片标题")

##### 流程
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160623_8fwk.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160917_9Ftz.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201904/14160633_u59G.png "在这里输入图片标题")
![输入图片说明](https://static.oschina.net/uploads/img/201907/05165142_yyQ7.png "在这里输入图片标题")


##### 手机端
![](https://oscimg.oschina.net/oscnet/da543c5d0d57baab0cecaa4670c8b68c521.jpg)
![](https://oscimg.oschina.net/oscnet/fda4bd82cab9d682de1c1fbf2060bf14fa6.jpg)

##### PAD端
![](https://oscimg.oschina.net/oscnet/e90fef970a8c33790ab03ffd6c4c7cec225.jpg)
![](https://oscimg.oschina.net/oscnet/d78218803a9e856a0aa82b45efc49849a0c.jpg)
![](https://oscimg.oschina.net/oscnet/0404054d9a12647ef6f82cf9cfb80a5ac02.jpg)
![](https://oscimg.oschina.net/oscnet/59c23b230f52384e588ee16309b44fa20de.jpg)


## 捐赠 

如果觉得还不错，请作者喝杯咖啡吧 ☺

![](https://static.oschina.net/uploads/img/201903/08155608_0EFX.png)
