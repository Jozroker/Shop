DROP DATABASE if EXISTS shop;
CREATE DATABASE if NOT EXISTS shop;
use shop;

DROP TABLE if EXISTS bucket_product; 
DROP TABLE if EXISTS user;
DROP TABLE if EXISTS product;
DROP TABLE if EXISTS bucket;

create table if not exists bucket(
	id int not null auto_increment,
   purchase_date timestamp not NULL,
   PRIMARY KEY (id)
   );

create table if not exists user(
	id int not NULL auto_increment,
	fname varchar(75) not null,
   lname varchar(100) not NULL,
   password varchar(30) not null,
   email varchar(75) not null unique,
   role varchar(50) not null,
   bucket_id int not null,
   PRIMARY KEY (id),
   foreign key (bucket_id) references bucket(id)
   );

create table product(
	id int not null primary key auto_increment,
   name varchar(75) not null unique,
   description TEXT not null,
   price decimal(8,2) not null,
   count int not null
   );

create table bucket_product (
	bucket_id int not null,
   product_id int not null,
   product_count int not null,
   foreign key (bucket_id) references bucket(id),
   foreign key (product_id) references product(id)
   );
