/*
Navicat MySQL Data Transfer

Source Server         : HR
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : employee

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-01-17 12:56:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `salary` double(8,2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'zhangsan', '5000.00', '23');
INSERT INTO `emp` VALUES ('2', 'emp01', '5500.00', '31');
INSERT INTO `emp` VALUES ('3', 'emp02', '6000.00', '32');
INSERT INTO `emp` VALUES ('4', '苏轼', '5000.00', '60');
INSERT INTO `emp` VALUES ('5', '李白', '8000.00', '33');
INSERT INTO `emp` VALUES ('25', 'emp03', '7000.00', '33');
