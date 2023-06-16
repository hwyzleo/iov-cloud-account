DROP TABLE IF EXISTS `db_account`.`tb_account`;
CREATE TABLE `db_account`.`tb_account`
(
    `id`                  BIGINT      NOT NULL AUTO_INCREMENT COMMENT '主键',
    `uid`                 VARCHAR(50) NOT NULL COMMENT '账号唯一ID',
    `username`            VARCHAR(50)          DEFAULT NULL COMMENT '用户名',
    `country_region_code` VARCHAR(20)          DEFAULT NULL COMMENT '手机所属国家或地区',
    `mobile`              VARCHAR(15)          DEFAULT NULL COMMENT '手机号',
    `email`               VARCHAR(255)         DEFAULT NULL COMMENT '邮箱',
    `nickname`            VARCHAR(50)          DEFAULT NULL COMMENT '昵称',
    `avatar`              VARCHAR(255)         DEFAULT NULL COMMENT '头像',
    `gender`              VARCHAR(50)          DEFAULT NULL COMMENT '性别',
    `description`         VARCHAR(255)         DEFAULT NULL COMMENT '备注',
    `create_time`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`           BIGINT               DEFAULT NULL COMMENT '创建者',
    `modify_time`         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `modify_by`           BIGINT               DEFAULT NULL COMMENT '修改者',
    `row_version`         INT                  DEFAULT NULL COMMENT '记录版本',
    `is_valid`            TINYINT              DEFAULT NULL COMMENT '是否有效',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`uid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='账号数据';

DROP TABLE IF EXISTS `db_account`.`tb_token`;
CREATE TABLE `db_account`.`tb_token`
(
    `id`                    BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `uid`                   VARCHAR(50)  NOT NULL COMMENT '账号唯一ID',
    `client_id`             VARCHAR(50)  NOT NULL COMMENT '客户端ID',
    `vin`                   VARCHAR(20)           DEFAULT NULL COMMENT '车架号',
    `scope`                 VARCHAR(255)          DEFAULT NULL COMMENT '权限范围',
    `token_type`            VARCHAR(20)  NOT NULL COMMENT '令牌类型',
    `issue_time`            TIMESTAMP    NOT NULL COMMENT '发行时间',
    `access_token`          VARCHAR(100) NOT NULL COMMENT '访问令牌',
    `access_token_expires`  TIMESTAMP    NOT NULL COMMENT '访问令牌过期时间',
    `refresh_token`         VARCHAR(100) NOT NULL COMMENT '刷新令牌',
    `refresh_token_expires` TIMESTAMP    NOT NULL COMMENT '刷新令牌过期时间',
    `description`           VARCHAR(255)          DEFAULT NULL COMMENT '备注',
    `create_time`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by`             BIGINT                DEFAULT NULL COMMENT '创建者',
    `modify_time`           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `modify_by`             BIGINT                DEFAULT NULL COMMENT '修改者',
    `row_version`           INT                   DEFAULT NULL COMMENT '记录版本',
    `is_valid`              TINYINT               DEFAULT NULL COMMENT '是否有效',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='令牌数据';