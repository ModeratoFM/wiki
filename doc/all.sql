drop table if exists test;
create table if not exists test
(
    id int auto_increment
    primary key,
    name varchar(50) null comment '名称',
    password varchar(50) null comment '密码'
)
default charset=utf8mb4 comment '测试';

insert into `test` (id, name, password) values (1,"测试","password")

