CREATE DATABASE `ds_0` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci';
CREATE DATABASE `ds_1` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci';

CREATE TABLE `user_0`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_1`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_2`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;