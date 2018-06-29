/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hna_bim_dev

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-29 15:41:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bi_city
-- ----------------------------
DROP TABLE IF EXISTS `bi_city`;
CREATE TABLE `bi_city` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标志',
  `code` varchar(20) DEFAULT '' COMMENT '城市代码',
  `name` varchar(50) DEFAULT '' COMMENT '城市名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_city
-- ----------------------------

-- ----------------------------
-- Table structure for bi_city_project
-- ----------------------------
DROP TABLE IF EXISTS `bi_city_project`;
CREATE TABLE `bi_city_project` (
  `city_id` int(20) DEFAULT NULL COMMENT '城市id',
  `project_id` int(20) DEFAULT NULL COMMENT '项目id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_city_project
-- ----------------------------

-- ----------------------------
-- Table structure for bi_company
-- ----------------------------
DROP TABLE IF EXISTS `bi_company`;
CREATE TABLE `bi_company` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标志',
  `code` varchar(20) DEFAULT '' COMMENT '公司编码',
  `name` varchar(50) DEFAULT '' COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_company
-- ----------------------------

-- ----------------------------
-- Table structure for bi_company_city
-- ----------------------------
DROP TABLE IF EXISTS `bi_company_city`;
CREATE TABLE `bi_company_city` (
  `company_id` int(20) NOT NULL COMMENT '公司id',
  `city_id` int(20) DEFAULT NULL COMMENT '城市id',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_company_city
-- ----------------------------

-- ----------------------------
-- Table structure for bi_group
-- ----------------------------
DROP TABLE IF EXISTS `bi_group`;
CREATE TABLE `bi_group` (
  `id` int(20) NOT NULL COMMENT '唯一标志',
  `code` varchar(20) DEFAULT '' COMMENT '集团编码',
  `name` varchar(50) DEFAULT '' COMMENT '集团名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_group
-- ----------------------------

-- ----------------------------
-- Table structure for bi_group_user
-- ----------------------------
DROP TABLE IF EXISTS `bi_group_user`;
CREATE TABLE `bi_group_user` (
  `group_id` int(20) NOT NULL COMMENT '集团id',
  `company_id` int(20) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_group_user
-- ----------------------------

-- ----------------------------
-- Table structure for bi_project
-- ----------------------------
DROP TABLE IF EXISTS `bi_project`;
CREATE TABLE `bi_project` (
  `id` int(20) NOT NULL COMMENT '唯一标志',
  `name` varchar(255) DEFAULT '' COMMENT '项目名称',
  `remark` varchar(255) DEFAULT '' COMMENT '项目备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_project
-- ----------------------------

-- ----------------------------
-- Table structure for bi_user_project
-- ----------------------------
DROP TABLE IF EXISTS `bi_user_project`;
CREATE TABLE `bi_user_project` (
  `user_id` int(20) DEFAULT NULL COMMENT '用户id',
  `project_id` int(20) DEFAULT NULL COMMENT '项目id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bi_user_project
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(20) NOT NULL AUTO_INCREMENT,
  `parent_id` int(20) DEFAULT NULL COMMENT '上级ID',
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `logType` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '日志类型',
  `navigation` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '创建者',
  `create_date` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '创建时间',
  `host` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作IP地址',
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求URI',
  `requestType` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '操作方式',
  `params` text COLLATE utf8_bin COMMENT '操作提交的数据',
  `exceptionMessage` text COLLATE utf8_bin COMMENT '异常信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9174 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '菜单排序',
  `delete_flag` int(10) DEFAULT '0' COMMENT '是否删除',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, '0', 'fa fa-cog', '0', '0', null, null);
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', 'user.html', '1', 'fa fa-user', '1', '0', '2018-04-11 15:29:16', '2018-04-11 15:29:16');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'role.html', '1', 'fa fa-user-secret', '2', '0', '2018-04-11 15:28:33', '2018-04-11 15:28:33');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'menu.html', '1', 'fa fa-th-list', '3', '0', '2018-04-11 15:28:35', '2018-04-11 15:28:35');
INSERT INTO `sys_menu` VALUES ('5', '1', '权限管理', 'privilege.html', '1', 'fa fa-th-list', '4', '0', '2018-04-11 14:42:06', '2018-04-11 14:42:06');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限名称',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `menu_id` int(11) DEFAULT NULL COMMENT '权限所属菜单ID',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限支付标识',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '是否删除（0未删除；1已删除）',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '系统管理权限', '1', 'sys', '0', '2018-06-28 17:30:33', '2018-06-28 17:30:33');
INSERT INTO `sys_privilege` VALUES ('2', '用户管理权限', '2', 'sys:user', '0', '2018-06-28 17:30:29', '2018-06-28 17:30:29');
INSERT INTO `sys_privilege` VALUES ('3', '角色管理权限', '3', 'sys:role', '0', '2018-06-28 17:30:26', '2018-06-28 17:30:26');
INSERT INTO `sys_privilege` VALUES ('4', '菜单管理权限', '4', 'sys:menu', '0', '2018-06-28 17:30:21', '2018-06-28 17:30:21');
INSERT INTO `sys_privilege` VALUES ('5', '权限管理权限', '5', 'sys:privilege', '0', '2018-06-28 17:30:44', '2018-06-28 17:30:44');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `status` int(1) DEFAULT '0' COMMENT '是否删除',
  `name_cn` varchar(100) DEFAULT NULL COMMENT '角色中文名称',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '删除状态（0未删除；1已删除）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '0', '管理员', '0', '2017-02-21 10:41:44', '2018-04-11 14:38:46');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `privilege_id` int(11) NOT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('1', '1');
INSERT INTO `sys_role_privilege` VALUES ('1', '2');
INSERT INTO `sys_role_privilege` VALUES ('1', '3');
INSERT INTO `sys_role_privilege` VALUES ('1', '4');
INSERT INTO `sys_role_privilege` VALUES ('1', '5');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `nick_name` varchar(50) DEFAULT '' COMMENT '昵称',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(255) NOT NULL COMMENT '密码盐',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `mobile` varchar(100) NOT NULL COMMENT '手机号',
  `status` int(4) DEFAULT '1' COMMENT '状态  0：禁用   1：正常',
  `delete_flag` int(1) DEFAULT '0' COMMENT '是否删除',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '53c8cb0fe3b22b2aaa2a90c019593622', 'e372cb', 'root@renren.io', '13612345678', '1', '0', '2016-11-11 11:11:11', '2018-04-11 14:53:27');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
