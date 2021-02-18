DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint  AUTO_INCREMENT NOT NULL,
  `component` varchar(255) DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `pid` bigint DEFAULT NULL,
  `sort` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)  ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `message_config`;
CREATE TABLE `message_config` (
  `id` bigint  AUTO_INCREMENT NOT NULL,
  `access_key_id` varchar(255) DEFAULT NULL,
  `access_key_secret` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `arg` blob,
  `create_time` datetime(6) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `log_code` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `api_secret` varchar(255) DEFAULT NULL,
  `app_id` varchar(255) DEFAULT NULL,
  `cert_name` varchar(255) DEFAULT NULL,
  `cert_stream` blob,
  `create_date` datetime(6) DEFAULT NULL,
  `mch_id` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `rabbit_mq_config`;
CREATE TABLE `rabbit_mq_config` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `enabled` bit(1) NOT NULL,
  `host` varchar(255) DEFAULT NULL,
  `interval` int DEFAULT NULL,
  `last_modify_date` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `port` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `business_type` int DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `key_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `storage_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `role_id` bigint NOT NULL,
  `menu_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `role_id` bigint NOT NULL,
  `permission_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `roles_users`;
CREATE TABLE `roles_users` (
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `access_key_id` varchar(255) DEFAULT NULL,
  `access_key_secret` varchar(255) DEFAULT NULL,
  `bucketname` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL,
  `endpoint` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `update_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint AUTO_INCREMENT NOT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_time` datetime(6) DEFAULT NULL,
  `status` int NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

  -- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '字典名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dict_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

-- ----------------------------
-- Table structure for sys_dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_detail`;
CREATE TABLE `sys_dict_detail` (
  `detail_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dict_id` bigint(11) DEFAULT NULL COMMENT '字典id',
  `label` varchar(255) NOT NULL COMMENT '字典标签',
  `value` varchar(255) NOT NULL COMMENT '字典值',
  `dict_sort` int(5) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`detail_id`) ,
  KEY `FK5tpkputc6d9nboxojdbgnpmyb` (`dict_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典详情';




-- ----------------------------
-- Table structure for KP_barCode_info
-- ----------------------------
DROP TABLE IF EXISTS `KP_barCode_info`;
CREATE TABLE `KP_barCode_info` (
    `ExternalBarCode` varchar(32) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `AdmDate` datetime DEFAULT NULL COMMENT '就诊日期',
    `admNo` varchar(25) DEFAULT NULL COMMENT '体检号等',
    `AgeUnit` varchar(1) DEFAULT NULL COMMENT '年龄单位',
    `BedNO` varchar(8) DEFAULT NULL COMMENT '床号',
    `CollectTime` datetime DEFAULT NULL COMMENT '采样时间',
    `DateOfbirth` datetime DEFAULT NULL COMMENT '出生日期',
    `Department` varchar(20) DEFAULT NULL COMMENT '送检科室',
    `Diagnose` varchar(40) DEFAULT NULL COMMENT '临床诊断',
    `DoctorName` varchar(20) DEFAULT NULL COMMENT '送检医生',
    `hospitalCode` varchar(32) NOT NULL COMMENT '医院代码',
    `IdentityCardNo` varchar(20) DEFAULT NULL COMMENT '身份证号',
    `InternalBarcode` varchar(32) NOT NULL COMMENT '医院条形码',
    `WSDWMC` varchar(50) DEFAULT NULL COMMENT '外送单位名称',
    `notes` varchar(100) DEFAULT NULL COMMENT '备注',
    `PAge` int DEFAULT NULL COMMENT '年龄',
    `PName` varchar(20) DEFAULT NULL COMMENT '姓名',
    `PNameENG` varchar(20) DEFAULT NULL COMMENT '英文名',
    `PSex` varchar(1) DEFAULT NULL COMMENT '性别',
    `PType` int DEFAULT NULL COMMENT '病人类型',
    `patientID` varchar(30) DEFAULT NULL COMMENT '病人ID',
    `GRBM` varchar(50) DEFAULT NULL COMMENT '个人编码',
    `RecieveTime` datetime DEFAULT NULL COMMENT '接收时间',
    `SendDate` datetime DEFAULT NULL COMMENT '送检日期',
    `SpecialDes` varchar(256) DEFAULT NULL COMMENT '特殊说明',
    `SpecimensStatus` varchar(20) DEFAULT NULL COMMENT '标本状态',
    `SpecimensType` varchar(16) DEFAULT NULL COMMENT '标本类型',
    `TestDest` varchar(8000) DEFAULT NULL COMMENT '送检项目名称',
    `TestDestCode` varchar(256) DEFAULT NULL COMMENT '送检项目代码',
    `Tubes` int DEFAULT NULL COMMENT '试管数',
  PRIMARY KEY (`ExternalBarCode`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- ----------------------------
-- Table structure for KP_report_info
-- ----------------------------
DROP TABLE IF EXISTS `KP_report_info`;
CREATE TABLE `KP_report_info` (
    `sampleNO` varchar(30) NOT NULL COMMENT '检测单位的样本',
    `hospitalCode` varchar(32) DEFAULT NULL COMMENT '医院代码',
    `ExternalBarCode` varchar(32) DEFAULT NULL COMMENT '外送的样本单号',
    `InternalBarcode` varchar(32) DEFAULT NULL COMMENT '医院条形码',
    `patientID` varchar(30) DEFAULT NULL COMMENT '病人ID',
    `PName` varchar(20) DEFAULT NULL COMMENT '姓名',
    `PNameENG` varchar(20) DEFAULT NULL COMMENT '英文名',
    `dateOfbirth` datetime DEFAULT NULL COMMENT '出生日期',
    `PAge` varchar(5) DEFAULT NULL COMMENT '年龄',
    `PSex` varchar(1) DEFAULT NULL COMMENT '性别',
    `AgeUnit` varchar(1) DEFAULT NULL COMMENT '年龄单位',
    `identityCardNo` varchar(20) DEFAULT NULL COMMENT '身份证号',
    `pType` numeric(1, 0) DEFAULT NULL COMMENT '病人类型',
    `AdmNo` varchar(25) DEFAULT NULL COMMENT '体检号等',
    `AdmDate` datetime DEFAULT NULL COMMENT '就诊日期',
    `BedNO` varchar(8) DEFAULT NULL COMMENT '床号',
    `Department` varchar(50) DEFAULT NULL COMMENT '送检科室',
    `DoctorName` varchar(20) DEFAULT NULL COMMENT '送检医生',
    `SpecimensType` varchar(16) DEFAULT NULL COMMENT '标本类型',
    `Diagnose` varchar(40) DEFAULT NULL COMMENT '临床诊断',
    `Tubes` int DEFAULT NULL COMMENT '试管数',
    `SpecimensStatus` varchar(20) DEFAULT NULL COMMENT '标本状态',
    `SendDate` datetime DEFAULT NULL COMMENT '送检日期',
    `CollectTime` datetime DEFAULT NULL COMMENT '采样时间',
    `RecieveTime` datetime DEFAULT NULL COMMENT '接收时间',
    `registerTime` datetime DEFAULT NULL COMMENT '检验日期',
    `registerName` varchar(50) DEFAULT NULL COMMENT '检验医生名字',
    `ReportTime` datetime DEFAULT NULL COMMENT '报告时间',
    `reportName` varchar(50) DEFAULT NULL COMMENT '报告医生名字',
    `MicroFlag` varchar(1) DEFAULT NULL COMMENT '微生物报告标志',
    `Notes` varchar(100) DEFAULT NULL COMMENT '备注',
    `PDFData` varchar(2000) DEFAULT NULL COMMENT 'PDF文件BASE64',
    `SaveFlag` int DEFAULT NULL COMMENT '接收标志',
  PRIMARY KEY (`sampleNO`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



-- ----------------------------
-- Table structure for KP_report_jyResult
-- ----------------------------
DROP TABLE IF EXISTS `KP_report_jyResult`;
CREATE TABLE `KP_report_jyResult` (
    `reportID` int NOT NULL AUTO_INCREMENT COMMENT '记录号',
    `sampleNO` varchar(30) NOT NULL COMMENT '检测单位的样本',
    `hospitalCode` varchar(10) NOT NULL COMMENT '医院代码',
    `InternalBarcode` varchar(32) NOT NULL COMMENT '医院条形码',
    `externalBarCode` varchar(32) NOT NULL COMMENT '外送的样本单号',
    `testCode` varchar(20) NOT NULL COMMENT '项目代码',
    `testName` varchar(60) DEFAULT NULL COMMENT '项目名称',
    `ItemNameEN` varchar(50) DEFAULT NULL COMMENT '项目英文名称',
    `areaCode` varchar(30) DEFAULT NULL COMMENT '区域编码',
    `ResultTip` varchar(10) DEFAULT NULL COMMENT '提示符',
    `ItemRef` varchar(256) DEFAULT NULL COMMENT '参考范围',
    `ItemUnit` varchar(10) DEFAULT NULL COMMENT '项目单位',
    `CriticalFlag` varchar(1) DEFAULT NULL COMMENT '危急警告',
    `Testmethod` varchar(20) DEFAULT NULL COMMENT '检测方法',
    `ResultOrder` varchar(5) DEFAULT NULL COMMENT '显示顺序',
    `CriticalMessage` varchar(2000) DEFAULT NULL COMMENT '危急值提示',
  PRIMARY KEY (`reportID`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;