/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.13-log : Database - spring_boot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_boot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring_boot`;

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `value` varchar(32) COLLATE utf8_bin NOT NULL,
  `href` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `parentIds` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `isLast` int(3) NOT NULL,
  `createUserId` int(11) DEFAULT NULL,
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `updateUserId` int(11) DEFAULT NULL,
  `updateTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(3) NOT NULL,
  `levelCode` int(3) NOT NULL,
  `orderCode` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_permission` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(128) COLLATE utf8_bin NOT NULL,
  `description` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `createUserId` int(11) DEFAULT NULL,
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `updateUserId` int(11) DEFAULT NULL,
  `updateTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_per` */

DROP TABLE IF EXISTS `sys_role_per`;

CREATE TABLE `sys_role_per` (
  `sysRoleId` int(11) NOT NULL,
  `sysPerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_role_per` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_bin NOT NULL,
  `loginName` varchar(100) COLLATE utf8_bin NOT NULL,
  `mobile` int(11) DEFAULT NULL,
  `salt` varchar(36) COLLATE utf8_bin NOT NULL,
  `password` varchar(32) COLLATE utf8_bin NOT NULL,
  `lastLoginIp` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `lastLoginTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `createUserId` int(11) DEFAULT NULL,
  `createTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `updateUserId` int(11) DEFAULT NULL,
  `updateTime` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `isDelete` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_user` */

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `sysUserId` int(11) NOT NULL,
  `sysRoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_user_role` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`password`,`role`) values ('zjk','123456','ROLE_USER');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
