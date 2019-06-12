create database java_registration;

use java_registration;

create table users
(
    id            int auto_increment
        primary key,
    title         varchar(10)  null,
    surname       varchar(255) null,
    other_names   varchar(255) null,
    gender        varchar(6)   null,
    dob           date         null,
    phone         varchar(15)  null,
    house_address varchar(255) null,
    emerg_person  varchar(255) null,
    emerg_phone   varchar(15)  null,
    emerg_rel     varchar(50)  null,
    email         varchar(255) null,
    pwd           varchar(255) null
);


