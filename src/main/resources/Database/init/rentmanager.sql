drop table if exists category;
drop table if exists products;
drop table if exists statuses;
drop table if exists customers;
drop table if exists roles;
drop table if exists rents;

create table category (id serial not null primary key,name varchar(50));

insert into category(id,category_name) values(default, 'Betonkeverők');
insert into category(id,category_name) values(default, 'Csiszológépek');
insert into category(id,category_name) values(default, 'Fúrók');
insert into category(id,category_name) values(default, 'Faipari gépek');
insert into category(id,category_name) values(default, 'Tömörítőgépek');
insert into category(id,category_name) values(default, 'Egyebek');
insert into category(id,category_name) values(default, 'Roppantók');
insert into category(id,category_name) values(default, 'Áramfejlesztők');
insert into category(id,category_name) values(default, 'Betonsimítók');
insert into category(id,category_name) values(default, 'Hőlégfúvók');
insert into category(id,category_name) values(default, 'Vizesvágók');

create table products(id serial not null primary key, name varchar(50) not null, price integer not null,category_id integer references category(id));

--WARNING: Configure this path to your own
copy products(name,price,category_id) from '/home/norbi/CodeCool/Advanced_Java/2nd_TW/rent_manager/src/main/resources/Database/init/gepek.csv' delimiter ';' csv header;

create table statuses(id serial primary key not null, name varchar(50));

insert into statuses (id,name) values (default, 'Available');
insert into statuses (id,name) values (default, 'Rented');
insert into statuses (id,name) values (default, 'Out of operation');

alter table products add column status_id integer references statuses(id);
UPDATE products SET status_id=1;

create table customers(id serial not null primary key, first_name varchar(50), last_name varchar(50), email varchar(70), address varchar(200),phone_number varchar(50));

create table roles(id serial not null primary key, name varchar(30));
insert into roles(id,name) values (default, 'admin');
insert into roles(id,name) values (default, 'employee');
create table users(id serial not null primary key, username varchar(50), password varchar(200), role_id integer references roles(id));
create table rents(id serial not null primary key, customer_id integer references customers(id), cost integer not null, booking_date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,start_date DATE not null ,end_date DATE not null);


