insert into categories (created_at, updated_at, name, description)
values (now(), now(), 'Electronics', 'Devices and gadgets'),
    (now(), now(), 'Books', 'Printed and digital books'),
    (now(), now(), 'Clothing', 'Men and women apparel'),
    (now(), now(), 'Home & Kitchen', 'Home appliances and kitchen tools');

insert into products (created_at, updated_at, name, description, price, quantity, category_id)
values (now(), now(), 'iPhone 15', 'Latest Apple smartphone', 999.99, 50,
        (select id from categories where name = 'Electronics')),
    (now(), now(), 'Samsung Galaxy S24', 'Flagship Samsung phone', 899.99, 40,
     (select id from categories where name = 'Electronics')),
    (now(), now(), 'Sony WH-1000XM5', 'Noise cancelling headphones', 349.99, 25,
     (select id from categories where name = 'Electronics'));

insert into products (created_at, updated_at, name, description, price, quantity, category_id)
values (now(), now(), 'Clean Code', 'A Handbook of Agile Software Craftsmanship', 39.99, 100,
        (select id from categories where name = 'Books')),
    (now(), now(), 'Spring in Action', 'Comprehensive Spring guide', 49.99, 80,
     (select id from categories where name = 'Books'));

insert into products (created_at, updated_at, name, description, price, quantity, category_id)
values (now(), now(), 'Classic White T-Shirt', '100% cotton t-shirt', 19.99, 200,
        (select id from categories where name = 'Clothing')),
    (now(), now(), 'Blue Denim Jeans', 'Slim fit jeans', 59.99, 120,
     (select id from categories where name = 'Clothing'));

insert into products (created_at, updated_at, name, description, price, quantity, category_id)
values (now(), now(), 'Air Fryer XL', 'Healthy cooking appliance', 129.99, 30,
        (select id from categories where name = 'Home & Kitchen')),
    (now(), now(), 'Espresso Machine', 'Automatic coffee maker', 249.99, 15,
     (select id from categories where name = 'Home & Kitchen'));
