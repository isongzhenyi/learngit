# Spring-REST
    如果说Web Service是一种特殊的RPC，那么REST Service又是一种特殊的Web Service，目前已成为分布式通信的重要手段。本项目基于Spring框架，完成REST（表现层状态转移）风格的接口的发布(Server)与接收(Client)。特性如下：
    
    
Server端：
    
    1.基于SpringMVC的@RequestMapping的属性method配置GET,POST,DELETE,PUT四种HTTP请求，对应于CRUD的四种操作；
    
    2.前端页面发送四种HTTP请求，可通过Jquery的ajax方法完成；
    
    3.前后台通过json通信，对于POST和PUT请求，ajax需要提交json字符串作为数据，后台用@RequestBody接收json转为java对象；
    
    4.已配置阿里巴巴的Fastjson工具作为消息转换器，controller返回的对象自动转json字符串到前端；
    
    5.Server端使用SSM框架，需要用mysql建立表格actor持久化数据：
    
      CREATE TABLE `actor` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(45) DEFAULT NULL,
        `age` int(11) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
      
     6.Server端入口：
     
       http://localhost:8080/Spring-REST-Server/rest
       
  Cilent端:
    
    1.客户端使用Spring的RestTemplate的API发送GET,POST,DELETE,PUT请求，底层是通过HttpClient实现远程调用；
    
    2.注意POST和PUT方法，发送的请求包含了HTTP头设置，否则容易出415的错误；
    
    3.前端页面提交json数据到后台的模板为：
    
     $.ajax({  
            url : "actors",  
            type : "POST/DELETE/PUT",  
            data : JSON.stringify(json), //转JSON字符串  
            dataType: 'json',  
            contentType:'application/json;charset=UTF-8', //contentType很重要
            success : function(result) { });
  

如果是GET请求，直接$.get(...)即可;

4.Client端入口：
    
      http://localhost:8080/Spring-REST-Client/rest
      
    效果图：
     ![输入图片说明](http://git.oschina.net/uploads/images/2017/0209/143942_9a9acde4_1110335.jpeg "在这里输入图片标题")

### 附录：个人作品索引目录（持续更新）

#### 基础篇:职业化，从做好OA系统开始
1. [SpringMVC,Mybatis,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/SSM)
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)
5. [Spring发布与调用REST风格的WebService](https://gitee.com/shenzhanwang/Spring-REST)
6. [Spring整合Apache Shiro框架，实现用户管理和权限控制](https://gitee.com/shenzhanwang/Spring-shiro)
7. [使用Spring security做权限控制](https://gitee.com/shenzhanwang/spring-security-demo)
8. [Spring整合Jasig CAS框架实现单点登录](https://gitee.com/shenzhanwang/Spring-cas-sso)
#### 中级篇：中间件的各种姿势
9. [Spring连接mongoDB数据库实现增删改查](https://gitee.com/shenzhanwang/Spring-mongoDB)
10. [Spring连接Redis实现缓存](https://gitee.com/shenzhanwang/Spring-redis)
11. [Spring连接图存数据库Neo4j实现增删改查](https://gitee.com/shenzhanwang/Spring-neo4j)
12. [Spring平台整合消息队列ActiveMQ实现发布订阅、生产者消费者模型（JMS）](https://gitee.com/shenzhanwang/Spring-activeMQ)
13. [Spring整合消息队列RabbitMQ实现四种消息模式（AMQP）](https://gitee.com/shenzhanwang/Spring-rabbitMQ)
14. Spring框架的session模块实现集中式session管理（未开源）
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查（未开源）
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)
18. 23种设计模式，源码、注释、使用场景（未开源）
19. 使用ETL工具Kettle的实例（未开源）
20. Git指南和分支管理策略（未开源）
#### 高级篇：架构之美
21. [搭建zookeeper集群提供目录服务](https://gitee.com/shenzhanwang/zookeeperjiqundajian)
22. 使用ubuntu+apache+SVN+SVNadmin+maven+Nexus+Hudson搭建持续集成环境（未开源）
23. 使用jenkins+centos+git+maven搭建持续集成环境自动化部署分布式服务（未开源）
24. Spring框架整合dubbo框架实现分布式服务治理（SOA架构）（未开源）
25. Spring框架整合dubbox实现微服务架构（MSA架构）（未开源）
26. 使用Spring Cloud实现微服务架构（MSA架构）（未开源）
27. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）（未开源）
28. 搭建高可用nginx集群和Tomcat负载均衡（未开源）
29. 搭建可扩展的ActiveMQ高可用集群（未开源）
30. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用（未开源）
31. 搭建高可用redis集群实现分布式缓存（未开源）
32. [Spring整合SolrJ实现全文检索](https://gitee.com/shenzhanwang/Spring-solr)
#### 特别篇：分布式事务和并发控制
33. 基于可靠消息最终一致性实现分布式事务（activeMQ）（未开源）
34. 使用TCC框架实现分布式事务（dubbo版）（未开源）
35. 使用TCC框架实现分布式事务（Spring Cloud版）（未开源）
36. 决战高并发：数据库锁机制和事务隔离级别的使用（未开源）
37. 决战高并发：Java多线程编程实例（未开源）
38. 决战高并发：使用netty实现高性能NIO通信（未开源）

### 捐赠区
![输入图片说明](https://images.gitee.com/uploads/images/2018/0719/154323_12a5c89c_1110335.jpeg "mm_facetoface_collect_qrcode_1531986023521.jpg")
