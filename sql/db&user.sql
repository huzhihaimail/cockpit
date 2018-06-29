-- create db
create database if not exists hna_bim_dev default charset utf8 collate utf8_general_ci;
-- create user
create user 'hnabimdev'@'%' identified by 'hnabimdev';
-- grant privileges
grant all privileges on hna_bim_dev.* to hnabimdev@"%" identified by 'hnabimdev' with grant option;