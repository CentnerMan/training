# drop schema if exists hotline;
CREATE SCHEMA IF NOT EXISTS hotline DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

USE hotline;

# CREATE TABLES AND MAKE PRIMARY INITIALIZATION

drop table if exists engineers;
create table engineers
(
    `id`         bigint      not null auto_increment,
    `login`      varchar(50) not null,
    `password`   varchar(80) not null,
    `first_name` varchar(50) not null,
    `last_name`  varchar(50) not null,
    `phone`      varchar(15),
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    `id`   bigint      NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `type_UNIQUE` (`name` ASC) VISIBLE
);

DROP TABLE IF EXISTS engineers_roles;
CREATE TABLE engineers_roles
(
    `engineer_id` bigint NOT NULL,
    `role_id`     bigint NOT NULL,
    PRIMARY KEY (`engineer_id`, `role_id`),
    FOREIGN KEY (`engineer_id`)
        REFERENCES `engineers` (`id`),
    FOREIGN KEY (`role_id`)
        REFERENCES `roles` (`id`)
);

drop table if exists regions;
create table regions
(
    `id`             bigint      not null,
    `region_name`    varchar(40) not null,
    `region_address` varchar(256),
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `region_name_UNIQUE` (`region_name` ASC) VISIBLE
);

drop table if exists agencies;
create table agencies
(
    `id`             bigint      not null,
    `agency_name`    varchar(60) not null,
    `agency_address` varchar(256),
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `agency_name_UNIQUE` (`agency_name` ASC) VISIBLE
);

DROP TABLE IF EXISTS idk_type;
CREATE TABLE idk_type
(
    `id`   bigint      NOT NULL,
    `type` varchar(25) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE
);

drop table if exists customs;
create table customs
(
    `id`           bigint      not null,
    `customs_name` varchar(60) not null,
    `agency`       bigint,
    `region`       bigint,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `customs_name_UNIQUE` (`customs_name` ASC) VISIBLE,
    INDEX `agency_id_idx` (`agency` ASC) VISIBLE,
    INDEX `region_id_idx` (`region` ASC) VISIBLE,
    FOREIGN KEY (`agency`)
        REFERENCES `agencies` (`id`),
    FOREIGN KEY (`region`)
        REFERENCES `regions` (`id`)
);

drop table if exists idk;
create table idk
(
    `id`       bigint      not null auto_increment,
    `idk_name` varchar(20) not null,
    `type`     bigint,
    `customs`  bigint,
    `kpp`      bigint,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `idk_name_UNIQUE` (`idk_name` ASC) VISIBLE,
    INDEX `type_id_idx` (`type` ASC) VISIBLE,
    INDEX `customs_id_idx` (`customs` ASC) VISIBLE,
    FOREIGN KEY (`type`)
        REFERENCES `idk_type` (`id`),
    FOREIGN KEY (`customs`)
        REFERENCES `customs` (`id`)

);

drop table if exists hotline;
create table hotline
(
    `id`         bigint    not null auto_increment,
    `watch_date` timestamp not null,
    `engineer`   bigint,
    `date_time`  timestamp not null,
    `idk`        bigint,
    `caller`     varchar(60),
    `error`      varchar(500),
    `actions`    varchar(500),
    `result`     varchar(500),
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `idk_id_idx` (`idk` ASC) VISIBLE,
    INDEX `engineer_id_idx` (`engineer` ASC) VISIBLE,
    FOREIGN KEY (`idk`)
        REFERENCES `idk` (`id`),
    FOREIGN KEY (`engineer`)
        REFERENCES `engineers` (`id`)
);

# ----------------------------------------------------------------
# ADDING INITIALIZE DATA

insert into engineers (`login`, `password`, `first_name`, `last_name`) /*pass=100*/
values ('averin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Александр', 'Аверин'),
       ('lebedev', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Анатолий', 'Лебедев'),
       ('platonov', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'Дмитрий', 'Платонов');

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO engineers_roles (engineer_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (3, 1);

insert into regions (`id`, `region_name`, `region_address`)
values (1, 'Санкт-Петербург', '190013, г.Санкт-Петербург, Введенский канал д.7 оф.308'),
       (2, 'Ростов-на-Дону', '344065, г.Ростов-на-Дону, ул. 50-летия Ростсельмаша, 2-6/22'),
       (3, 'Новосибирск', '630049, г. Новосибирск, Красный пр., д.220, корп. 2, оф.329'),
       (4, 'Находка', '692921, Приморский край, г.Находка ул.Владивостокская д.52'),
       (7, 'Центр', 'Москва');

insert into agencies (`id`, `agency_name`)
values (1, 'Северо-Западное таможенное управление'),
       (2, 'Центральное таможенное управление'),
       (3, 'Южное таможенное управление'),
       (6, 'Сибирское таможенное управление'),
       (7, 'Дальневосточное таможенное управление'),
       (8, 'Северо-Кавказское таможенное управление'),
       (9, 'ФТС');

insert into customs (`id`, `customs_name`, `agency`, `region`)
VALUES (1, 'Балтийская', 1, 1),
       (2, 'Кингисеппская', 1, 1),
       (3, 'Выборгская', 1, 1),
       (4, 'Псковская', 1, 1),
       (5, 'Калининградская', 9, 1),
       (8, 'Брянская', 2, 7),
       (9, 'Находкинская', 7, 4),
       (10, 'Уссурийская', 7, 4),
       (11, 'Владивостокская', 7, 4),
       (12, 'Хабаровская', 7, 4),
       (13, 'Биробиджанская', 7, 4),
       (14, 'Благовещенская', 7, 4),
       (15, 'Читинская', 6, 3),
       (19, 'Бурятская', 6, 3),
       (26, 'Дагестанская', 8, 2),
       (27, 'Миллеровская', 3, 2),
       (28, 'Астраханская', 3, 2),
       (29, 'Новороссийская', 3, 2),
       (30, 'Таганрогская', 3, 2),
       (31, 'Воронежская', 2, 2),
       (32, 'Белгородская', 2, 2),
       (33, 'Ростовская', 3, 2),
       (34, 'Северо - Осетинская', 8, 2),
       (36, 'Крымская', 9, 2),
       (37, 'Курская', 2, 7),
       (38, 'Сочинская', 3, 2);

INSERT INTO idk_type (`id`, `type`)
VALUES (1, 'HCV-Mobile'),
       (2, 'HCV-Gantry'),
       (3, 'HCVG 6040'),
       (4, 'HCV-Stationary'),
       (5, 'THSCAN MB1215HL'),
       (6, 'CT2630M'),
       (7, 'СТ6035'),
       (8, 'TFN BX-1215');

insert into idk (`idk_name`, `type`, `customs`, `kpp`)
VALUES ('10343', 5, 32, 35),
       ('10362', 5, 8, 38),
       ('10398', 5, 8, 39),
       ('850188', 4, 29, 48),
       ('850189', 4, 1, 18),
       ('850190', 4, 9, 10),
       ('850526', 1, 33, 49),
       ('850548', 1, 3, 23),
       ('850568', 1, 14, 6),
       ('850569', 1, 9, 9),
       ('850570', 1, 15, 28),
       ('850571', 1, 10, 11),
       ('850572', 1, 11, 7),
       ('850573', 1, 12, 14),
       ('850574', 1, 26, 57),
       ('850575', 1, 32, 34),
       ('850576', 1, 29, 47),
       ('850577', 1, 10, 12),
       ('850578', 1, 11, 8),
       ('850579', 1, 10, 13),
       ('850580', 1, 5, 1),
       ('850581', 1, 2, 20),
       ('850582', 1, 3, 24),
       ('850583', 1, 15, 29),
       ('850584', 1, 37, 40),
       ('850585', 1, 31, 42),
       ('850586', 1, 30, 51),
       ('850587', 1, 32, 32),
       ('850588', 1, 13, 5),
       ('850589', 1, 19, 31),
       ('850590', 1, 27, 44),
       ('850591', 1, 1, 16),
       ('850592', 1, 1, 17),
       ('850593', 1, 26, 55),
       ('850594', 1, 5, 2),
       ('850595', 1, 5, 3),
       ('850596', 1, 37, 41),
       ('850597', 1, 36, 4),
       ('850601', 2, 8, 36),
       ('850608', 2, 4, 25),
       ('850609', 2, 3, 21),
       ('850610', 2, 3, 22),
       ('850611', 2, 4, 26),
       ('851506', 1, 30, 52),
       ('851507', 1, 38, 54),
       ('851508', 1, 32, 33),
       ('851509', 1, 28, 43),
       ('851510', 1, 1, 15),
       ('851511', 1, 29, 45),
       ('851512', 1, 8, 37),
       ('851513', 1, 2, 19),
       ('851514', 1, 29, 46),
       ('851515', 1, 4, 27),
       ('851608', 3, 26, 56),
       ('851611', 3, 34, 59),
       ('851613', 3, 34, 58),
       ('851617', 3, 30, 53),
       ('851801', 3, 15, 30),
       ('851805', 3, 33, 50);
