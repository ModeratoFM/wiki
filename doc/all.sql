drop table if exists test;
create table if not exists test
(
    id int auto_increment
    primary key,
    name varchar(50) null comment '名称',
    password varchar(50) null comment '密码'
)
default charset=utf8mb4 comment '测试';

insert into `test` (id, name, password) values (1,"测试","password");


drop table if exists `demo`;
create table if not exists demo(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine=innodb default char set =utf8mb4 comment ='测试';

insert into `demo` (id, name) values (1,'测试');
