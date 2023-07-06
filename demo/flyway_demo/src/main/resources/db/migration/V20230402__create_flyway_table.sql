CREATE TABLE `user_test`.`flyway`  (
  `id` int NULL,
  `name` varchar(255) NULL COMMENT '名称'
);
insert into `user_test`.`flyway` (id, name) values (1, '测试数据1');
insert into `user_test`.`flyway` (id, name) values (2, '测试数据2');