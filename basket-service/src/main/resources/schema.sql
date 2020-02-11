DROP TABLE IF EXISTS BASKET;

CREATE TABLE BASKET
(
    id        INTEGER PRIMARY KEY auto_increment,
    user_id   INTEGER ,
    product_id INTEGER ,
    quantity VARCHAR(64));