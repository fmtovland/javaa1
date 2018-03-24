create user javadev@localhost identified by 'java=dmv';
create database javadev;
use javadev;
/*a list of all files and their sha checksum
the table name contains underscores. hopefully
this will stop it being confused for a word table*/
create table __files_index_list__
(
	filename varchar(200),
	checksum varchar(40) primary key
);
grant select on javadev.* to javadev@localhost;
grant insert on javadev.* to javadev@localhost;
grant create on javadev.* to javadev@localhost;
