create table tb_user
(
    id       int auto_increment
        primary key,
    name     varchar(32) null,
    password varchar(32) null
);

INSERT INTO spring.tb_user (id, name, password) VALUES (1, 'root', '123456');
INSERT INTO spring.tb_user (id, name, password) VALUES (2, 'lihua', '123456');