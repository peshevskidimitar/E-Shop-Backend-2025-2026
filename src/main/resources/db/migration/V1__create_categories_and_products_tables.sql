create table categories (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    description varchar(255)
);

create table products (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    name varchar(255) not null,
    description varchar(255),
    price numeric(19, 2) not null,
    quantity integer not null,
    category_id bigint not null references categories(id) on delete cascade
);
