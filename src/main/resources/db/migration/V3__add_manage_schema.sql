create schema if not exists management;

create table management.user (
    id bigserial not null primary key,
    name varchar
);

insert into management.user(name) values ('Mark Sievers');
