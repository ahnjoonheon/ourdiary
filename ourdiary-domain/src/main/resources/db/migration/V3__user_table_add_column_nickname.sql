alter table member add column nickname varchar(50) not null ;
alter table member modify column nickname varchar(50) not null after profile_pic;