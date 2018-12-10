/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2018-12-10 16:07:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '无意义自增主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '创建用户',
  `is_valid` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用，1:启用     0:不启用',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '更新用户',
  `version` int(20) NOT NULL DEFAULT '0' COMMENT '版本号',
  `address` varchar(255) NOT NULL COMMENT '具体地址',
  `city` varchar(32) NOT NULL COMMENT '城市',
  `country` varchar(16) NOT NULL COMMENT '国家',
  `label` varchar(16) NOT NULL COMMENT '地址标签（家、公司）',
  `province` varchar(32) NOT NULL COMMENT '省份',
  `web_user_id` bigint(30) DEFAULT NULL COMMENT '无意义自增主键',
  PRIMARY KEY (`id`),
  KEY `FK6kglr8wulaoxbs32v9pydrw2f` (`web_user_id`),
  CONSTRAINT `FK6kglr8wulaoxbs32v9pydrw2f` FOREIGN KEY (`web_user_id`) REFERENCES `webuser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '2018-12-09 17:26:29', '0', '0', '2018-12-09 17:27:30', '0', '0', '中国深圳', '深圳', '中国', '大厦', '广东', '1');
INSERT INTO `address` VALUES ('2', '2018-12-09 17:27:26', '0', '0', '2018-12-09 17:27:35', '0', '0', '中国深圳2', '深圳2', '中国2', '大厦2', '广东2', '1');

-- ----------------------------
-- Table structure for webuser
-- ----------------------------
DROP TABLE IF EXISTS `webuser`;
CREATE TABLE `webuser` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '无意义自增主键',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '创建用户',
  `is_valid` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用，1:启用     0:不启用',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` bigint(10) NOT NULL DEFAULT '0' COMMENT '更新用户',
  `version` int(20) NOT NULL DEFAULT '0' COMMENT '版本号',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(32) DEFAULT '' COMMENT '昵称',
  `password` varchar(32) NOT NULL DEFAULT '000000' COMMENT '密码',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webuser
-- ----------------------------
INSERT INTO `webuser` VALUES ('1', '2018-12-09 17:24:04', '0', '0', '2018-12-09 17:24:43', '0', '0', '1@qq.com', '测试', '000000', '用户');
INSERT INTO `webuser` VALUES ('4', '2018-12-09 17:24:40', '0', '0', '2018-12-09 17:24:40', '0', '0', '2@qq.com', '测试2', '111111', '用户2');
INSERT INTO `webuser` VALUES ('5', '2018-12-09 17:25:02', '0', '0', '2018-12-09 17:25:02', '0', '0', '3@qq.com', '测试3', '222222', '用户3');
INSERT INTO `webuser` VALUES ('6', '2018-12-09 17:25:17', '0', '0', '2018-12-09 17:25:17', '0', '0', '4@qq.com', '测试4', '333333', '用户4');
INSERT INTO `webuser` VALUES ('7', '2018-12-09 17:25:37', '0', '0', '2018-12-09 17:25:37', '0', '0', '5@qq.com', '测试5', '444444', '用户5');
