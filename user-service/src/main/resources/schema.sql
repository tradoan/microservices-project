DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
    id        INTEGER PRIMARY KEY auto_increment,
    first_name   VARCHAR(64),
    last_name   VARCHAR(64),
    email   VARCHAR(64),
    password VARCHAR(64));