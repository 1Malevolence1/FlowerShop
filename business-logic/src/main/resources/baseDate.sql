
-- Создание новой схемы и таблиц
CREATE SCHEMA IF NOT EXISTS flowers;

create table flowers.type_flower(
    type_flower_id serial primary key,
    type_name varchar(30) not null unique,
    description text
);

CREATE TABLE flowers.suppliers (
    supplier_id SERIAL PRIMARY KEY,
    supplier_name VARCHAR(100) NOT NULL,
    city varchar(50) not null ,
    contact_phone VARCHAR(20),
    contact_email VARCHAR(100),
    address TEXT not  null
);



create table flowers.flowers(
    flower_id serial primary key,
    title varchar not null check (length(trim(title)) > 0 )  unique,
    price integer not null,
    extra_charge integer not null,
    supplier_id integer,

    foreign key (supplier_id) references flowers.suppliers(supplier_id)

);




create table flowers.inventory_flower(
    inventory_id serial primary key,
    flower_id integer,
    accounting_quantity integer NOT NULL,
    actual_quantity integer NOT NULL,
    foreign key (flower_id) references flowers.flowers(flower_id)
);


CREATE TABLE flowers.flower_type_relation (
    flower_id INTEGER,
    type_flower_id INTEGER,
    PRIMARY KEY (flower_id, type_flower_id),
    FOREIGN KEY (flower_id) REFERENCES flowers.flowers(flower_id),
    FOREIGN KEY (type_flower_id) REFERENCES flowers.type_flower(type_flower_id)
)




