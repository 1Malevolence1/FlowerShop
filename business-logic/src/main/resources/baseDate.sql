
-- Создание новой схемы и таблиц
CREATE SCHEMA IF NOT EXISTS manager;

create table manager.type_flower(
    type_flower_id serial primary key,
    type_name varchar(30) not null unique,
    description text
);



create table manager.flowers(
    flower_id serial primary key,
    title varchar not null check (length(trim(title)) > 0 )  unique,
    price integer not null,
    extra_charge integer not null
);

create table manager.inventory_flower(
    inventory_id serial primary key,
    flower_id integer,
    accounting_quantity integer NOT NULL,
    actual_quantity integer NOT NULL,
    foreign key (flower_id) references manager.flowers(flower_id)
);


CREATE TABLE manager.flower_type_relation (
    flower_id INTEGER,
    type_flower_id INTEGER,
    PRIMARY KEY (flower_id, type_flower_id),
    FOREIGN KEY (flower_id) REFERENCES manager.flowers(flower_id),
    FOREIGN KEY (type_flower_id) REFERENCES manager.type_flower(type_flower_id)
)




