alter table users add column nickname varchar(50) not null ;
alter table users modify column nickname varchar(50) not null after profile_pic;