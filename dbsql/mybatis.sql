/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-06-13 14:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `article_content` varchar(5000) DEFAULT NULL COMMENT '文章内容',
  `userid` int(11) unsigned NOT NULL COMMENT '作者ID',
  `blogid` int(11) unsigned DEFAULT NULL COMMENT '博客ID',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '《可惜不是你》', '瞧你个损色！', '1', '1');
INSERT INTO `article` VALUES ('2', '《世界杯来了》', '于2018年6月14日在俄罗斯正式揭幕！', '5', '2');
INSERT INTO `article` VALUES ('3', '《我就是这么拽》', '不想活了', '3', '2');
INSERT INTO `article` VALUES ('4', '《追风少年》', '是游戏不好玩，还是电视不好看', '4', '1');
INSERT INTO `article` VALUES ('5', '《穿越回古代》', '梦见自己做了皇帝', '2', '4');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `blog_title` varchar(50) DEFAULT NULL COMMENT '博客专栏名称',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '青葱岁月');
INSERT INTO `blog` VALUES ('2', '体育世界');
INSERT INTO `blog` VALUES ('3', '母婴早教');
INSERT INTO `blog` VALUES ('4', '历史军事');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_userName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_userAge` int(3) unsigned DEFAULT NULL COMMENT '年龄',
  `user_userAddress` varchar(500) DEFAULT NULL COMMENT '住址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '慕容雪', '36', '北京');
INSERT INTO `user` VALUES ('2', '尼罗', '26', '上海');
INSERT INTO `user` VALUES ('3', '阿皮亚', '20', '深圳');
INSERT INTO `user` VALUES ('4', '阿凡提', '22', '杭州');
INSERT INTO `user` VALUES ('5', '玛德', '32', '美利坚');
INSERT INTO `user` VALUES ('7', 'test_add', '30', 'place');
