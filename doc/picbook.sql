#电子书表
DROP TABLE IF EXISTS `ebook`;
CREATE TABLE `ebook` (
                         `id` bigint NOT NULL COMMENT 'id',
                         `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
                         `category1_id` bigint DEFAULT NULL COMMENT '分类1',
                         `category2_id` bigint DEFAULT NULL COMMENT '分类2',
                         `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
                         `cover` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '封面',
                         `dou_count` int DEFAULT NULL COMMENT '文档数',
                         `view_count` int DEFAULT NULL COMMENT '阅读数',
                         `vote_count` int DEFAULT NULL COMMENT '点赞数',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;




INSERT INTO `wikidev`.`ebook`(`id`, `name`, `category1_id`, `category2_id`, `description`, `cover`, `dou_count`, `view_count`, `vote_count`) VALUES (1, 'Spring boot 入门教程', NULL, NULL, '零基础入门java开发，企业级应用开发最佳首选框架', NULL, NULL, NULL, NULL);
INSERT INTO `wikidev`.`ebook`(`id`, `name`, `category1_id`, `category2_id`, `description`, `cover`, `dou_count`, `view_count`, `vote_count`) VALUES (2, 'vue入门教程', NULL, NULL, '零基础入门vue开发，企业级应用开发最佳首选框架', NULL, NULL, NULL, NULL);
INSERT INTO `wikidev`.`ebook`(`id`, `name`, `category1_id`, `category2_id`, `description`, `cover`, `dou_count`, `view_count`, `vote_count`) VALUES (3, 'Python 入门教程', NULL, NULL, '零基础入门Python开发，企业级应用开发最佳首选框架', NULL, NULL, NULL, NULL);
INSERT INTO `wikidev`.`ebook`(`id`, `name`, `category1_id`, `category2_id`, `description`, `cover`, `dou_count`, `view_count`, `vote_count`) VALUES (4, 'Mysql 入门教程', NULL, NULL, '零基础入门Mysql开发，企业级应用开发最佳首选框架', NULL, NULL, NULL, NULL);
INSERT INTO `wikidev`.`ebook`(`id`, `name`, `category1_id`, `category2_id`, `description`, `cover`, `dou_count`, `view_count`, `vote_count`) VALUES (5, 'Oracle入门教程', NULL, NULL, '零基础入门Oracle开发，企业级应用开发最佳首选框架', NULL, NULL, NULL, NULL);