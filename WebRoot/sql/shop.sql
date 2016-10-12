/*
Navicat MySQL Data Transfer

Source Server         : HQL
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-10-12 08:43:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('24', '夏季时尚男鞋', '589', 'shoes-1.png');
INSERT INTO `item` VALUES ('27', '不系带 跑鞋', '358.8', 'shoes-12.png');
INSERT INTO `item` VALUES ('28', '阿迪达斯 懒人鞋', '563', 'shoes-2.png');
INSERT INTO `item` VALUES ('29', '炫蓝 跑鞋', '268.6', 'shoes-3.png');
INSERT INTO `item` VALUES ('30', '篮球鞋 奥运同款', '250', 'shoes-5.png');
INSERT INTO `item` VALUES ('31', '厚重 篮球鞋', '563', 'shoes-6.png');
INSERT INTO `item` VALUES ('32', '高帮 休闲鞋', '562', 'shoes-7.png');
INSERT INTO `item` VALUES ('33', '登山 跑步必备鞋', '558', 'shoes-8.png');
INSERT INTO `item` VALUES ('36', '激情 足球鞋', '250', 'shoes-13.png');
INSERT INTO `item` VALUES ('37', '休闲 学生板鞋', '354', 'shoes-3.png');
INSERT INTO `item` VALUES ('38', '金黑 板鞋', '600', 'shoes-16.png');
INSERT INTO `item` VALUES ('39', '运动 防滑鞋', '1000', 'shoes-15.png');
INSERT INTO `item` VALUES ('40', '时尚 涂鸦鬼鞋', '895', 'shoes-10.png');
INSERT INTO `item` VALUES ('42', '时尚另类 鞋', '456', 'HqBLsF67UwmfpZz.png');
INSERT INTO `item` VALUES ('43', '耐克', '420.6', 'b-1.png');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('zxj', '521538zxj');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xww', '123456789');
SET FOREIGN_KEY_CHECKS=1;
