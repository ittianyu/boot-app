create database boot_app
 CHARSET utf8;

USE boot_app;

CREATE TABLE account (
 id INT PRIMARY KEY AUTO_INCREMENT,
 username VARCHAR(64) NOT NULL UNIQUE,
 nickname VARCHAR(64) NOT NULL,
 password CHAR(64) NOT NULL,
 status TINYINT NOT NULL COMMENT '0:unverified, 1:normal, 2:forbidden',
 token VARCHAR(128) NOT NULL DEFAULT '',
 token_expire_time BIGINT NOT NULL DEFAULT 0,
 created_time BIGINT NOT NULL COMMENT 'Registered time in millisecond',
 updated_time BIGINT NOT NULL COMMENT 'Information updated time in millisecond'
)
 ENGINE = InnoDB
 DEFAULT CHARSET utf8;

CREATE TABLE account_auth (
 id INT PRIMARY KEY AUTO_INCREMENT,
 account_id INT NOT NULL,
 verify_type TINYINT NOT NULL DEFAULT 0 COMMENT '0:none, 1:email, 2:phone, 3:captcha, 4:code',
 verify_account VARCHAR(128) NOT NULL DEFAULT '' COMMENT 'Such as phone number, email',
 verify_code VARCHAR(64) NOT NULL DEFAULT ''
)
 ENGINE = InnoDB
 DEFAULT CHARSET utf8;

# used for auth type "code"
CREATE TABLE auth_code (
 id INT PRIMARY KEY AUTO_INCREMENT,
 code VARCHAR(64) NOT NULL UNIQUE,
 used TINYINT NOT NULL DEFAULT 0 COMMENT '0:no, 1:yes',
 version INT NOT NULL DEFAULT 0 COMMENT 'Multi-Version Concurrency Control'
)
 ENGINE = InnoDB
 DEFAULT CHARSET utf8;


CREATE TABLE config (
 key_ VARCHAR(64) PRIMARY KEY,
 value_ TEXT NOT NULL
)
 ENGINE = InnoDB
 DEFAULT CHARSET utf8;
