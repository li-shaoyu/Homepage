/******************************************/
/*   DatabaseName = kkbdb   */
/*   TableName = kkb_edu   */
/******************************************/
CREATE TABLE `kkb_edu` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(20) DEFAULT NULL COMMENT '用户编号',
  `start` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开始时间',
  `end` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '结束时间',
  `school` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学校',
  `study` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '专业名称',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`),
  KEY `edu_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于描述用户的学习'
;

/******************************************/
/*   DatabaseName = kkbdb   */
/*   TableName = kkb_skill   */
/******************************************/
CREATE TABLE `kkb_skill` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(20) DEFAULT NULL COMMENT '用户编号',
  `keywords` varchar(1024) DEFAULT NULL COMMENT '用户的技能词列表',
  PRIMARY KEY (`id`),
  KEY `skill_userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户技能表'
;

/******************************************/
/*   DatabaseName = kkbdb   */
/*   TableName = kkb_specialty   */
/******************************************/
CREATE TABLE `kkb_specialty` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(20) DEFAULT NULL COMMENT '用户编号',
  `name` varchar(64) DEFAULT NULL COMMENT '特长名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='用于描述用户特长'
;

/******************************************/
/*   DatabaseName = kkbdb   */
/*   TableName = kkb_user   */
/******************************************/
CREATE TABLE `kkb_user` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户唯一标示，用于关联教育经历、工作经历、特长以及技能列表',
  `name` varchar(16) DEFAULT NULL COMMENT '姓名',
  `age` int(8) DEFAULT NULL COMMENT '年龄',
  `city` varchar(32) DEFAULT NULL COMMENT '地区城市',
  `address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话或手机号码',
  `weixin` varchar(64) DEFAULT NULL COMMENT '微信号码',
  `qq` varchar(32) DEFAULT NULL COMMENT 'qq号码',
  `weibo` varchar(256) DEFAULT NULL COMMENT '微博地址',
  `sex` varchar(8) DEFAULT NULL COMMENT '用户性别',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户基础信息表，包含了用户的基本信息'
;

/******************************************/
/*   DatabaseName = kkbdb   */
/*   TableName = kkb_work   */
/******************************************/
CREATE TABLE `kkb_work` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(20) DEFAULT NULL COMMENT '用户编号',
  `start` varchar(64) DEFAULT NULL COMMENT '开始时间',
  `end` varchar(64) DEFAULT NULL COMMENT '结束时间',
  `company` varchar(64) DEFAULT NULL COMMENT '所在公司',
  `job` varchar(64) DEFAULT NULL COMMENT '岗位名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '工作描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用于描述用户的工作经历'
;
