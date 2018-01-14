CREATE TABLE `me_sys_user_info` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '自增长id\r\n',
`username` varchar(50) NULL,
`sex` int(1) NULL,
`year` int(4) NULL,
`month` int(2) NULL,
`hour` int(4) NULL,
`Horoscope_year` char(2) NULL,
`Horoscope_month` char(2) NULL,
`Horoscope_day` char(2) NULL,
`Horoscope_hour` char(2) NULL,
`calendar` int(1) NULL,
`create_time` datetime NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `me_sys_five_elements` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`parent_id` int(11) NULL COMMENT '该字段对应用户表或者头像图片表',
`gold` int(1) NULL,
`wood` int(1) NULL,
`water` int(1) NULL,
`fire` int(1) NULL,
`soil` int(1) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `me_sys_portrait_info` (
`id` int(11) NOT NULL,
`Portrait_name` varchar(50) NULL,
`star` int(2) NULL,
PRIMARY KEY (`id`) 
);

