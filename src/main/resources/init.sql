create table if not exists `user`(
  uid int primary key auto_increment,
  uname varchar(20) not null,
  passwd varchar(255) not null,
  balance double default 0
);
create table if not exists `products`(
  pid int primary key auto_increment,
  pname varchar(20) not null,
  price double default 0,
  category varchar(20) not null.
  description varchar(255)
);
insert into `products` (`pname`,`price`,`category`,`description`) values
("iphone",6499,"phone","this is iphone!"),
("ipad",6000,"pad","this is ipad"),
("mac",9999,"computer","this is imac");
