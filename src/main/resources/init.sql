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
  description varchar(255)
);