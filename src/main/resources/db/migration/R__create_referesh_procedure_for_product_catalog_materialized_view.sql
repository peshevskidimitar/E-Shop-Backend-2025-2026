create or replace procedure refresh_product_catalog_view()
language sql
AS $$
    refresh materialized view concurrently product_catalog_view;
$$