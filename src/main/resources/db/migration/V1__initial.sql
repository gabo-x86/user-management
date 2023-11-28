/**
  * Migration sql script
  */

--user TABLE CREATION
create table "user"(
                       id integer not null primary key,
                       username varchar(150) not null,
                       "password" varchar(150) not null,
                       email varchar(150) not null,
                       created_at timestamp
);
create sequence user_sequence as integer increment 1;

--rol TABLE CREATION
create table rol(
                    id integer not null primary key,
                    "name" varchar(100) not null
);
create sequence rol_sequence as integer increment 1;

--user_rol TABLE CREATION
create table user_rol(
                         id integer not null primary key,
                         active boolean,
                         created_at timestamp not null,
                         user_id bigint, --FK
                         rol_id int,		--FK
                         constraint fk_user_rol foreign key(user_id) references "user"(id) on delete restrict,
                         constraint fk_rol_user foreign key(rol_id) references rol(id) on delete restrict
);
create sequence user_rol_sequence as integer increment 1;

--user_detail TABLE CREATION
create table user_detail(
                            id bigint not null primary key,
                            first_name varchar(100) not null,
                            last_name varchar(100) not null,
                            "age" integer,
                            birth_day date,
                            user_id bigint unique,	--FK
                            constraint fk_user_detail foreign key(user_id) references "user"(id) on delete cascade
);
create sequence user_detail_sequence as integer increment 1;