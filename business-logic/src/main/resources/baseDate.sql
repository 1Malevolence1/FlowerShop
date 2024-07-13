
/*
DROP TABLE IF EXISTS flowers.flower_type_relation CASCADE;
DROP TABLE IF EXISTS flowers.inventory_flower CASCADE;
DROP TABLE IF EXISTS flowers.flowers CASCADE;
DROP TABLE IF EXISTS flowers.contact_supplier CASCADE;
DROP TABLE IF EXISTS flowers.suppliers CASCADE;
DROP TABLE IF EXISTS flowers.type_flower CASCADE;
*/



create table flowers.type_flower(
    type_flower_id serial primary key,
    type_name varchar(30) not null unique,
    description text
);

create table flowers.inventory_flower(
    inventory_id serial primary key,
    accounting_quantity integer NOT NULL,
    actual_quantity integer NOT NULL
);

create table flowers.contact_supplier(
       contact_id serial primary key,
       supplier_name varchar(50) not null,
       supplier_contact varchar(20) not null,
       supplier_email varchar(50) not null
);


CREATE TABLE flowers.suppliers (
    supplier_id  SERIAL PRIMARY KEY,
    supplier_name VARCHAR(100) NOT NULL unique ,
    city varchar(50) not null ,
    address TEXT not null,
    contact_id integer references flowers.contact_supplier(contact_id)
);



create table flowers.flowers(
    flower_id serial primary key,
    title varchar not null check (length(trim(title)) > 0 )  unique,
    price integer not null,
    extra_charge integer not null,
    inventory_id integer references flowers.inventory_flower(inventory_id),
    supplier_id INTEGER REFERENCES flowers.suppliers(supplier_id)
);





CREATE TABLE flowers.flower_type_relation (
    flower_id INTEGER,
    type_flower_id INTEGER,
    PRIMARY KEY (flower_id, type_flower_id),
    FOREIGN KEY (flower_id) REFERENCES flowers.flowers(flower_id) on delete cascade ,
    FOREIGN KEY (type_flower_id) REFERENCES flowers.type_flower(type_flower_id) on  delete cascade
)




