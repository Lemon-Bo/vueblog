/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : vueblog

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2021-04-12 12:49:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_blog
-- ----------------------------
DROP TABLE IF EXISTS `m_blog`;
CREATE TABLE `m_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `content` longtext,
  `created` datetime NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of m_blog
-- ----------------------------
INSERT INTO `m_blog` VALUES ('1', '1', 'hello word', '程序员的第一句话', '## Hello Word', '2021-04-10 16:20:57', '0');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `status` int(5) NOT NULL,
  `created` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES ('1', 'markerhub', 'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg', null, '96e79218965eb72c92a549dd5a330112', '0', '2020-04-20 10:44:01', null);
