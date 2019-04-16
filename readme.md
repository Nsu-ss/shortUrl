
//数据库生成
create table url
(
	id int auto_increment,
	url varchar(255) null comment '实际url',
	shortKey varchar(255) null comment '短码',
	type int null comment '0代表系统生成，1代表自定义',
	count int default 0 null comment '点击次数',
	`created-at` timestamp default now() null comment '生产时间',
	constraint url_pk
		primary key (id)
);

alter table url
	add `key` varchar(255) null comment '自定义key';
	
	
	由于没有域名，使用localhost代替
	由于没有时间（出差中)
	使用测试代替页面功能
	该项目实现了，长地址转短地址的基本功能
	（自定义key、自定义位数、自定义短地址、短网址访问计数、）
	由于使用的是安全hash算法，没有时间研究自定义字符集
	（但也有大致的方向：存储url返回主键id，设置基本字符集，用id对字符集长度进行取整、去摸运算
	得到的数字对应 字符集的下标）
	
	