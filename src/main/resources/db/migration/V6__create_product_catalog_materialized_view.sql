create materialized view product_catalog_view as
select p.id as id,
    p.name as product_name,
    p.description as product_description,
    p.price as product_price,
    p.quantity as product_quantity,
    c.id as category_id,
    c.name as category_name,
    count(ci.id) as times_added_to_cart,
    sum(ci.quantity) as total_quantity_in_carts,
    p.created_at,
    p.updated_at
from products as p
         join categories as c on p.category_id = c.id
         left join cart_items ci on ci.product_id = p.id
group by p.id, p.name, p.description, p.price, p.quantity,
    c.id, c.name, p.created_at, p.updated_at;

create unique index idx_product_catalog_view_id
    on product_catalog_view(id);