
drop table tblFile;
create table tblFile(
  seq number primary key, 
  name varchar2(30) not null, 
  filename varchar2(50) not null, 
  regdate date default sysdate not null
);

drop sequence seqFile;
create sequence seqFile;


