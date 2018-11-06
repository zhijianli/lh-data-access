DROP TABLE IF EXISTS `adver_info`;
CREATE TABLE `adver_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '广告 标题',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '广告说明',
  `image_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片id',
  `content_type` tinyint(2) NOT NULL COMMENT '广告跳转页面type（0-url 1-自定义内容 2-无内容 3-应用内跳转）',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面内容',
  `valid_flag` tinyint(2) DEFAULT 1 COMMENT '是否有效0 删除 1有效',
  `stick_flag` tinyint(2) DEFAULT 0 COMMENT '是否置顶（0-否 1-是）',
  `stick_time` datetime(0) DEFAULT NULL COMMENT '置顶时间',
  `enable_flag` tinyint(2) DEFAULT 0 COMMENT '启用状态（0-否 1-是）',
  `enable_time` datetime(0) DEFAULT NULL COMMENT '启用时间',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `update_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告' ROW_FORMAT = Compact;

DROP TABLE IF EXISTS `user_role_map`;
CREATE TABLE `user_role_map`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长序列',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户Id',
  `user_name` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id (1:登录权限 2:客服 3:客服经理)',
  `create_id` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建者时间',
  `update_id` varchar(24) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '更新者id',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新者时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户权限映射表' ROW_FORMAT = Compact;
DROP TABLE IF EXISTS `video_info`;
CREATE TABLE `video_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL COMMENT '视频分类：1为手绘宣教区，2为普通宣教区',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `brief_introduction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简介',
  `cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面地址',
  `video_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频地址',
  `uptime` datetime(0) DEFAULT NULL COMMENT '上线时间',
  `release_flag` tinyint(4) DEFAULT NULL COMMENT '是否发布，0为未发布，1为已发布',
  `top_flag` tinyint(4) DEFAULT NULL COMMENT '是否置顶，0为未置顶，1为已置顶',
  `create_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人id',
  `update_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `valid_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除，0删除，1有效',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'video视频表' ROW_FORMAT = Compact;
DROP TABLE IF EXISTS `flash_game`;
CREATE TABLE `flash_game`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面地址',
  `flash_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'flash地址',
  `uptime` datetime(0) DEFAULT NULL COMMENT '上线时间',
  `release_flag` tinyint(4) DEFAULT NULL COMMENT '是否发布，0为未发布，1为已发布',
  `top_flag` tinyint(4) DEFAULT NULL COMMENT '是否置顶，0为未置顶，1为已置顶',
  `create_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人id',
  `update_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新人',
  `valid_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除，0删除，1有效',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'flash游戏' ROW_FORMAT = Compact;