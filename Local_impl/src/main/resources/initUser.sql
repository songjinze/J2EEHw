create table IF NOT EXISTS `user`(
  uid int primary key auto_increment,
  uname varchar(20) not null,
  passwd varchar(255) not null,
  balance double default 0
);
