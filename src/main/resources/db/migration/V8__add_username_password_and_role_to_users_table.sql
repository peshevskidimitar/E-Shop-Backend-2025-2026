alter table users add column username varchar(255) unique;
alter table users add column password varchar(255) unique;
alter table users add column role varchar(255);