-- The initial dump of my existing schema

create table transport.car (
    created timestamptz default now() not null,
    id bigserial primary key not null,
    rego varchar not null unique,
    ebox_id bigserial not null
);

create table transport.ebox (
	id bigserial primary key not null,
	serial varchar not null,
	generation integer not null
);

alter table transport.car add constraint ebox_fk foreign key (ebox_id) references transport.ebox (id);

insert into transport.ebox (serial, generation) values ('1234', 1);

insert into transport.car (rego, ebox_id) values ('abc123', 1);
