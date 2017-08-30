/*
SQLyog v10.2 
MySQL - 5.5.56 : Database - news
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`news` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `news`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_num` int(11) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`department_id`,`department_num`,`department_name`) values (1,5,'ll'),(3,5,'后勤部'),(4,4,'销售部'),(13,5,'学生部');

/*Table structure for table `manage` */

DROP TABLE IF EXISTS `manage`;

CREATE TABLE `manage` (
  `manage_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL,
  `department_id` int(32) NOT NULL,
  PRIMARY KEY (`manage_id`),
  KEY `user_id` (`user_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `manage_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `news_user` (`username`),
  CONSTRAINT `manage_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `manage` */

insert  into `manage`(`manage_id`,`user_id`,`department_id`) values (2,'123456789',3),(3,'a123a1',13),(4,'12311',13),(5,'112233',4),(6,'11223344',3),(9,'0210236',13),(11,'01234',1);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `news_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `department_id` int(64) NOT NULL COMMENT '栏目编码',
  `mian_img` varchar(128) DEFAULT NULL COMMENT '主图',
  `detail` longtext NOT NULL COMMENT '详情',
  `keyword` varchar(20) DEFAULT NULL COMMENT '关键词',
  `top` int(11) DEFAULT '0' COMMENT '是否置顶（0否；1是）',
  `state` int(11) DEFAULT '1' COMMENT '状态（0待发布；1发布）',
  `user_id` varchar(50) DEFAULT NULL COMMENT '操作人',
  `SYS_CODE` varchar(64) DEFAULT NULL COMMENT '系统编码',
  `grtime` datetime DEFAULT NULL COMMENT '创建时间',
  `uptime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`news_id`),
  KEY `user_id` (`user_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `news_user` (`username`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`news_id`,`title`,`department_id`,`mian_img`,`detail`,`keyword`,`top`,`state`,`user_id`,`SYS_CODE`,`grtime`,`uptime`) values (1,'习近平会见全国公安系统英雄模范立功集体表彰大会代表',1,NULL,'全国公安系统英雄模范立功集体表彰大会19日上午在北京举行。中共中央总书记、国家主席、中央军委主席习近平亲切会见全国公安系统英雄模范立功集体表彰大会代表并发表重要讲话。习近平代表党中央、国务院和中央军委，向受到表彰的先进集体和先进个人表示热烈的祝贺，向全国公安战线的同志们表示诚挚的慰问。他强调，全国公安机关和公安队伍要坚持党对公安工作的领导，牢固树立“四个意识”，坚持人民公安为人民，全面加强正规化、专业化、职业化建设，做到对党忠诚、服务人民、执法公正、纪律严明。','习近平',0,1,'12311',NULL,'2017-05-20 06:58:13','2017-05-24 13:41:46'),(6,'外媒:特朗普专机噪音超标 或被比利时罚6.2万欧元',3,NULL,'据埃菲社5月17日援引比利时《最新消息报》和弗拉芒广播电视台报道，美国总统专机是VC-25飞机，是拥有特殊配置的波音747-200B飞机。这种飞机产生的噪音超出了布鲁塞尔机场的噪音限制规定。该机场要求，在此降落和起飞的所有飞机都必须达到“相当安静”的标准，以免对机场周围的居民造成影响。\r\n根据布鲁塞尔机场的规定，“空军一号”噪音超标将使白宫为此支付1250至6.2万欧元的罚款，罚款具体数额会依据噪音的危害程度、降落时的风力大小和降落时间不同而进行确定。比利时媒体报道称，最终的罚款数额预计在5000至9500欧元之间。','特朗普',0,1,'12311',NULL,'2017-05-20 06:58:13','2017-06-11 16:32:16'),(12,'aaaaaa',4,NULL,'<p>\n	<span style=\"background-color:#daa520;\">aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</span></p>\n','aaaa',0,1,'12311',NULL,'2017-05-23 13:40:30','2017-05-24 13:41:47'),(15,'qqq',1,NULL,'<p>\n	fdgdgfdgdg</p>\n<p>\n	fdgdgfdgdgwwwww</p>\n<h3 style=\"color:blue;\">\n	fdgdgfdgdgwwwwwwww</h3>\n','z',0,1,'12311',NULL,'2017-05-23 13:52:11','2017-06-11 16:32:13'),(22,'vcxvxcv',1,NULL,'<p>\n	cvxvxcv</p>\n','vcxvxc',0,1,'12311',NULL,'2017-05-25 12:46:11','2017-05-25 12:46:11'),(30,'速度跟上时代步伐',3,NULL,'<p>\n	vcxxcvcxvcxvxcvcxvcxv</p>\n','vcxvxcv',1,1,'12311',NULL,'2017-05-25 13:16:00','2017-05-25 13:16:00'),(32,'fdsfsdfsdfd',3,NULL,'<p>\n	<img alt=\"\" src=\"http://inews.gtimg.com/newsapp_bt/0/980019300/641\" style=\"width: 640px; height: 480px;\" /></p>\n','fdsf',1,1,'12311',NULL,'2017-05-25 13:49:42','2017-06-11 16:32:11');

/*Table structure for table `news_user` */

DROP TABLE IF EXISTS `news_user`;

CREATE TABLE `news_user` (
  `username` varchar(40) NOT NULL,
  `password` tinytext NOT NULL,
  `level` int(5) NOT NULL COMMENT '0-超级管理员,1是普通管理员',
  `code` text,
  `state` int(10) DEFAULT NULL COMMENT '用户状态码',
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `news_user` */

insert  into `news_user`(`username`,`password`,`level`,`code`,`state`,`email`) values ('01234','0123',2,NULL,1,'user1@news.com'),('0210236','123',2,NULL,1,'user1@news.com'),('112233','123a',2,NULL,1,'user1@news.com'),('11223344','1234',2,NULL,1,'user1@news.com'),('12311','a123a',3,'2d12d6146db242279aa3eea4788c85e0',0,'user1@news.com'),('123456789','a123a4a',2,NULL,1,'user2@news.com'),('a123a1','aa1111aa',1,'026d56761d25452c8f303501db7f88d6',0,'123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
