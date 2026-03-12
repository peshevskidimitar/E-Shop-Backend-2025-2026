create or replace view user_cart_summary_view as
select
    u.id as id,
    u.name || ' ' || u.surname as full_name,
    u.email,
    count(ci.id) as total_items,
    sum(ci.quantity) as total_quantity,
    sum(ci.quantity * p.price) as total_price
from users as u
    left join shopping_carts as sc on sc.user_id = u.id
    left join cart_items as ci on ci.shopping_cart_id = sc.id
    left join products as p on p.id = ci.product_id
group by u.id, u.name, u.surname, u.email
order by u.id;