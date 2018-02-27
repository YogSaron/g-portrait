/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : db_portrait

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2018-02-27 18:18:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for me_sys_five_elements
-- ----------------------------
DROP TABLE IF EXISTS `me_sys_five_elements`;
CREATE TABLE `me_sys_five_elements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '该字段对应用户表或者头像图片表',
  `gold` int(1) DEFAULT NULL,
  `wood` int(1) DEFAULT NULL,
  `water` int(1) DEFAULT NULL,
  `fire` int(1) DEFAULT NULL,
  `soil` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of me_sys_five_elements
-- ----------------------------

-- ----------------------------
-- Table structure for me_sys_portrait_info
-- ----------------------------
DROP TABLE IF EXISTS `me_sys_portrait_info`;
CREATE TABLE `me_sys_portrait_info` (
  `id` int(11) NOT NULL,
  `Portrait_name` varchar(50) DEFAULT NULL,
  `star` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of me_sys_portrait_info
-- ----------------------------

-- ----------------------------
-- Table structure for me_sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `me_sys_user_info`;
CREATE TABLE `me_sys_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长id\r\n',
  `username` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `hour` int(4) DEFAULT NULL,
  `Horoscope_year` char(2) DEFAULT NULL,
  `Horoscope_month` char(2) DEFAULT NULL,
  `Horoscope_day` char(2) DEFAULT NULL,
  `Horoscope_hour` char(2) DEFAULT NULL,
  `calendar` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of me_sys_user_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `resource_type` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `permission` varchar(30) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(80) DEFAULT NULL,
  `available` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '用户管理', 'menu', 'userInfo/userList', 'userInfo:view', '0', '0/', '0');
INSERT INTO `sys_permission` VALUES ('2', '用户添加', 'button', 'userInfo/userAdd', 'userInfo:add', '1', '0/1', '0');
INSERT INTO `sys_permission` VALUES ('3', '用户删除', 'button', 'userInfo/userDel', 'userInfo:del', '1', '0/1', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role` varchar(20) DEFAULT NULL,
  `description` varchar(60) DEFAULT NULL,
  `available` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '0');
INSERT INTO `sys_role` VALUES ('2', 'vip', 'VIP会员', '0');
INSERT INTO `sys_role` VALUES ('3', 'test', 'test', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '3', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', '14e1b600b1fd579f47433b88e8d85291', '8d78869f470951332959580424d4bf4f', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
