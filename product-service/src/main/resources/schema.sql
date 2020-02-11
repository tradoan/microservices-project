DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT
(
    id        INTEGER PRIMARY KEY auto_increment,
    name   VARCHAR(64),
    description VARCHAR(64),
    price DECIMAL (12, 2));