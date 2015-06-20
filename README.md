#Spring Security Session Redis UserDetails Rest API 手机APP后端 后台管理 综合一体化方案

##启动应用：
mvn spring-boot:run


##访问在线API文档:
http://localhost:8080/debug/index.html 即可在线查看API手册和调试API。


###1、注册用户： /api/create
###2、http://localhost:8080/ 测试“多重认证”
###3、http://localhost:8080/admin/ 登录访问图形管理界面
###4、http://localhsot:8080/lightadmin/ 可GUI管理数据库


##create user table:

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
