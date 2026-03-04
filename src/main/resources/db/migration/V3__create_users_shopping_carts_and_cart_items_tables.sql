create table users (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    email varchar(255) not null unique
);

create table shopping_carts (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    user_id bigint not null unique references users(id) on delete cascade
);

create table cart_items (
    id bigserial primary key,
    shopping_cart_id bigint not null references shopping_carts(id) on delete cascade,
    product_id bigint not null references products(id),
    quantity integer not null
);
