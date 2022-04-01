drop table if exists users;
drop table if exists review;
drop table if exists restaurant;


-- creating restaurant table
create table restaurant(
	-- id auto increment
	id serial,

	-- name is varchar (25 is the size of name)
	name varchar(25) not null,

	city varchar(25) not null,

	state varchar(25) not null
);


create table review (
	id serial,

	rating int not null,

	message varchar(100) not null,

	restaurant_id int
);

create table users (
	id serial,
	username varchar(25) not null,
	password varchar(25) not null
);


---Select
select * from restaurant;
select * from review;