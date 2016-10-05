/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Guinness
 * Created: Sep 28, 2016
 */

create schema db_access_control_silliman;
use db_access_control_silliman;

drop table if exists students;
create table students(
id int auto_increment primary key
,id_no varchar(255)
,fname varchar(255)
,mname varchar(255)
,lname varchar(255)
,year_level varchar(255)
,course varchar(255)
,status int 
,created_by varchar(255)
,updated_by varchar(255)
,created_at datetime
,updated_at datetime
);

drop table if exists faculty_and_staffs;
create table faculty_and_staffs(
id int auto_increment primary key
,id_no varchar(255)
,fname varchar(255)
,mname varchar(255)
,lname varchar(255)
,college varchar(255)
,status int 
,created_by varchar(255)
,updated_by varchar(255)
,created_at datetime
,updated_at datetime
);

drop table if exists access_logs;
create table access_logs(
id int auto_increment primary key
,id_no varchar(255)
,fname varchar(255)
,mname varchar(255)
,lname varchar(255)
,year_level varchar(255)
,course varchar(255)
,college varchar(255)
,status int 
,created_by varchar(255)
,updated_by varchar(255)
,created_at datetime
,updated_at datetime
);

drop table if exists users;
create table users(
id int auto_increment primary key
,screen_name varchar(255)
,username varchar(255)
,password varchar(255)
,status int 
,created_by varchar(255)
,updated_by varchar(255)
,created_at datetime
,updated_at datetime
);