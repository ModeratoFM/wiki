create table if not exists test
(
    id int auto_increment
    primary key,
    name varchar(50) null comment '名称'
)
default charset=utf8mb4 comment '测试';

