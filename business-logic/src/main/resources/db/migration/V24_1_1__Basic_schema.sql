
create schema if not exists manager;
drop table if  exists manager.flowers;


create table manager.flowers(
    id serial primary key,
    title varchar not null check (length(trim(title)) >0 ) unique,
    price money not null,
    extra_charge money not null,
    accounting_quantity int not null,
    actual_quantity int not null
);

