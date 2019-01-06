create table IF NOT EXISTS `user`(
  uid int primary key auto_increment,
  uname varchar(20) not null,
  passwd varchar(255) not null,
  balance double default 0
);

create table IF NOT EXISTS `products`(
  pid int primary key auto_increment,
  pname varchar(20) not null,
  price double default 0,
  category varchar(20) not null,
  description varchar(255)
);

insert into `products` (`pname`,`price`,`category`,`description`) values
("iphone",6499,"phone","this is an phone"),
("ipad",4999,"pad","this is aa ipad"),
("mac",14000,"computer","this is a mac"),
("dell",20000,"computer","this is a dell computer");