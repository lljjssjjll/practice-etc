drop table if exists member cascade;
create table member (
    id integer primary key generated by default as identity,
    /*id integer primary key generated by default as identity 와 동일*/
--     id bigserial primary key,
    /*Custom id 삽입 불가능*/
--     id integer primary key generated always as identity,
--     id integer primary key,
    name varchar(100)
);
