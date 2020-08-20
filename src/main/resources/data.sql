INSERT INTO app_user (id, first_name, last_name, email) VALUES
  (1,'Simon', 'Elbrink', 'simon@lexicon.se'),
  (2, 'Ulf', 'Bengtsson', 'ulf@lexicon.se'),
  (3,'Fredrik', 'Odin', 'fredrik@lexicon.se'),
  (4, 'Mehrdad', 'Javan', 'mehrdad@lexicon.se');

INSERT INTO product (id, name, price) VALUES
    (10, 'Book', 150),
    (20, 'T-Shirt', 190);

INSERT INTO product_order (id, order_date_time, customer_id) VALUES
    (1000, '2020-01-01 17:00:00', 1),
    (2000, '2020-01-02 16:00:00', 1),
    (3000, '2020-01-31 15:00:00', 2);

INSERT INTO order_item (id, quantity, product_id, product_order_id) VALUES
    (100, 2, 10, 1000),
    (200, 2, 10, 2000),
    (300, 2, 20, 3000);

INSERT INTO product_order_order_items (product_order_id, order_items_id) VALUES
    (1000,100),
    (2000,200),
    (3000,300);





