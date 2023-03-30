--liquibase formatted sql

--changeset motorin:1
CREATE TABLE IF NOT EXISTS client
(
    id BIGSERIAL PRIMARY KEY ,
    discount1 INT4,
    discount2 INT4,
    firstname VARCHAR(255),
    lastname VARCHAR(255)
);
--rollback DROP TABLE client

--changeset motorin:2
CREATE TABLE IF NOT EXISTS deal
(
    id BIGSERIAL PRIMARY KEY ,
    check_number VARCHAR(255),
    deal_date TIMESTAMP,
    client_id INT8 REFERENCES client(id)
);
--rollback DROP TABLE deal

--changeset motorin:3
CREATE TABLE IF NOT EXISTS deal_position
(
    deal_id INT8 NOT NULL REFERENCES deal(id),
    discount INT4,
    original_price INT4,
    product_id INT8,
    quantity INT4,
    total_price INT4
);
--rollback DROP TABLE deal_position

--changeset motorin:4
CREATE TABLE IF NOT EXISTS product
(
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    price INT4
);
--rollback DROP TABLE product


--changeset motorin:5
CREATE TABLE IF NOT EXISTS product_evaluations
(
    product_id INT8 NOT NULL REFERENCES product(id),
    client_id INT8,
    evaluation INT4
);
--rollback DROP TABLE product_evaluations

--changeset motorin:6
CREATE TABLE IF NOT EXISTS random_discount
(
    id BIGSERIAL PRIMARY KEY,
    created_at DATE,
    discount INT4,
    product_id INT8
);
--rollback DROP TABLE random_discount