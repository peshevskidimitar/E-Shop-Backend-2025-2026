insert into users (created_at, updated_at, name, surname, email)
values (now(), now(), 'John', 'Doe', 'john.doe@example.com'),
    (now(), now(), 'Jane', 'Smith', 'jane.smith@example.com'),
    (now(), now(), 'Alice', 'Johnson', 'alice.johnson@example.com'),
    (now(), now(), 'Bob', 'Brown', 'bob.brown@example.com');

insert into shopping_carts (created_at, updated_at, user_id)
values (now(), now(), (select id from users where email = 'john.doe@example.com')),
    (now(), now(), (select id from users where email = 'jane.smith@example.com')),
    (now(), now(), (select id from users where email = 'alice.johnson@example.com')),
    (now(), now(), (select id from users where email = 'bob.brown@example.com'));

insert into cart_items (shopping_cart_id, product_id, quantity)
values ((select sc.id
         from shopping_carts sc
                  join users u on sc.user_id = u.id
         where u.email = 'john.doe@example.com'),
        (select id from products where name = 'iPhone 15'),
        1),
    ((select sc.id
      from shopping_carts sc
               join users u on sc.user_id = u.id
      where u.email = 'john.doe@example.com'),
     (select id from products where name = 'Clean Code'),
     2);

insert into cart_items (shopping_cart_id, product_id, quantity)
values ((select sc.id
         from shopping_carts sc
                  join users u on sc.user_id = u.id
         where u.email = 'jane.smith@example.com'),
        (select id from products where name = 'Blue Denim Jeans'),
        1),
    ((select sc.id
      from shopping_carts sc
               join users u on sc.user_id = u.id
      where u.email = 'jane.smith@example.com'),
     (select id from products where name = 'Espresso Machine'),
     1);

insert into cart_items (shopping_cart_id, product_id, quantity)
values ((select sc.id
         from shopping_carts sc
                  join users u on sc.user_id = u.id
         where u.email = 'alice.johnson@example.com'),
        (select id from products where name = 'Sony WH-1000XM5'),
        1);
