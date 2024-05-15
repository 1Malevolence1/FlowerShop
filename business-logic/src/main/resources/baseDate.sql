
create schema if not exists manager;



create table manager.flowers(
    id serial primary key,
    title varchar not null check (length(trim(title)) > 0 )  unique,
    price integer not null,
    extra_charge integer not null,
    accounting_quantity integer not null,
    actual_quantity integer not null
);






