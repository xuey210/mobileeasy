#Spring Security Session Redis UserDetails Rest API 手机APP后端 后台管理 综合一体化方案

##架构设计
![Alt 架构设计](https://cloud.githubusercontent.com/assets/3350211/8512734/6e6de47a-2383-11e5-8f1f-f30632b556d1.png)
##业务逻辑层次划分
![业务逻辑层次划分](https://cloud.githubusercontent.com/assets/3350211/8520535/a580a94a-240d-11e5-8516-1d6f1b1ef317.jpg)
##在线API参考手册
![Alt 在线API参考手册](https://cloud.githubusercontent.com/assets/3350211/8520167/a0072938-240a-11e5-8f74-4496a72f0355.png)
##管理后台主页
![Alt 管理后台主页](https://cloud.githubusercontent.com/assets/3350211/8520168/a477b604-240a-11e5-84c1-8dc71d2f5496.png)
##管理后台-用户管理
![Alt 管理后台-用户管理](https://cloud.githubusercontent.com/assets/3350211/8520171/a6689f3c-240a-11e5-8f2c-889a77f871ff.png)
##数据库管理后台-基于lightadmin
![lightadmin-database](https://cloud.githubusercontent.com/assets/3350211/8520344/e0bfb958-240b-11e5-90b4-78625bd0e3de.png)
##启动应用：
mvn spring-boot:run


##访问在线API文档:
http://localhost:8080/debug/index.html 即可在线查看API手册和调试API。

##操作步骤
#####1、注册用户： /api/create
#####2、http://localhost:8080/ 测试“多重认证”（web form和httpBasic）
#####3、http://localhost:8080/admin/ 登录访问图形管理界面
#####4、http://localhsot:8080/lightadmin/ 可GUI管理数据库


##创建数据库
create user table:

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `image` varchar(200) DEFAULT '',
  `enabled` varchar(45) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


CREATE TABLE `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`,`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


##API保活访问采用cookie方式：
curl http://localhost:8080/api/i/user/9 -H "Cookie:SESSION=5b55e933-7c68-4333-82e4-656d777d72a4"
