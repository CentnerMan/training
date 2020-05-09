-- drop schema if exists students;
-- CREATE SCHEMA IF NOT EXISTS students DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

-- USE students;

drop table if exists student;

create table student
(
    id bigserial,
    name varchar(50) not null,
    mark  int,
    PRIMARY KEY (id)
);
