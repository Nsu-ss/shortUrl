
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