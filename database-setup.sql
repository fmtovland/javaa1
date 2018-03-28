create user javadev@localhost identified by 'java=dmv';
create database javadev;
use javadev;
grant select on javadev.* to javadev@localhost;
grant insert on javadev.* to javadev@localhost;
grant create on javadev.* to javadev@localhost;
