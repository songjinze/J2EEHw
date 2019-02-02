create table IF NOT EXISTS `products`(
  pid int primary key auto_increment,
  pname varchar(20) not null,
  price double default 0,
  category varchar(20) not null,
  description varchar(255)
);
