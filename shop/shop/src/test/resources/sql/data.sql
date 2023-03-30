INSERT INTO Client (id, firstName, lastname, discount1, discount2)
VALUES (1, 'Ivan', 'Ivanov', 5, 5),
       (2, 'Sergey', 'Novikov', 5, 5),
       (3, 'Anna', 'Chirokova', 5, 5),
       (4, 'Artem', 'Andreev', 5, 5),
       (5, 'Ekaterina', 'Bychenko', 5, 5),
       (6, 'Roman', 'Kruglov', 5, 5)
;


INSERT INTO Product (id, description, name, price)
VALUES (1,'Мощный пылесос', 'Пылесос.Polaris', 2500),
       (2,'Хороший чайник', 'Чайник.Puma', 1500),
       (3,'Домашний телефон', 'Телефон.Nokia', 8900),
       (4,'Мохровые тапки', 'Тапки.Adidas', 200),
       (5,'Крепкий стол', 'Стол.Lenta', 5000),
       (6,'Большое зеркало', 'Зеркало.Kreta', 3500)
;

INSERT INTO Product_evaluations (product_id, client_id, evaluation)
VALUES (3,2,2),
       (2,1,5),
       (3,1,4),
       (3,4,5),
       (5,5,3),
       (4,3,2),
       (4,1,3),
       (1,1,4),
       (1,2,5),
       (6,5,4)
;

INSERT INTO Deal (check_number, deal_date, client_id)
VALUES ('00100','2023-02-01',3),
       ('00101','2023-02-15',2)
;

INSERT INTO Deal_position (deal_id, quantity, discount, original_price, product_id, total_price)
VALUES
    (1, 2, 5, 5000, 1, 4750),
    (1, 1, 0, 1500, 2, 1500),
    (2, 3, 5, 600, 4, 570),
    (2, 2, 5, 10000, 5, 9500)
;

INSERT INTO random_discount (created_at, discount, product_id)
VALUES ('2023-03-29', 5, 2);
