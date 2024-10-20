--create table
drop table telbook;
create table telbook (
  seq number primary key, 
  name varchar2(10) not null, 
  age number(3) not null check(age between 1 and 99), 
  gender char(1) not null check(gender in ('m', 'f')), 
  tel varchar2(15) not null, 
  address varchar2(300) not null, 
  regdate date  default sysdate not null
);
desc telbook;
drop   SEQUENCE telbook_seq; 
create SEQUENCE telbook_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 9999;  
SELECT 	telbook_seq.CURRVAL from dual;    
SELECT 	telbook_seq.NEXTVAL from dual;    

SELECT telbook_seq.NEXTVAL   FROM dual;
SELECT telbook_seq.CURRVAL   FROM dual;

select max(seq) from telbook;

-- 한개의 데이터 입력
insert into telbook(seq, name, age, gender, tel, address, regdate) 
  values(telbook_seq.NEXTVAL, '홍길동', '22', 'm', '010-1234-1234', '서울시 서초구 서초로 1', default );
select * from telbook; 

-- 여러개의 데이터 입력
insert into telbook(seq, name, age, gender, tel, address, regdate) 
  values(telbook_seq.NEXTVAL, '홍길동', '22', 'm', '010-1234-2234', '서울시 서초구 서초로 2', default );
insert into telbook(seq, name, age, gender, tel, address, regdate) 
  values(telbook_seq.NEXTVAL, '홍길서', '22', 'm', '010-1234-3202', '서울시 서초구 서초로 3', default ); 
insert into telbook(seq, name, age, gender, tel, address, regdate) 
  values(telbook_seq.NEXTVAL, '홍길남', '22', 'f', '010-1234-4203', '서울시 서초구 서초로 4', default );  
insert into telbook(seq, name, age, gender, tel, address, regdate) 
  values(telbook_seq.NEXTVAL, '홍길북', '23', 'f', '010-1234-5204', '서울시 서초구 서초로 5', default );   
select * from telbook; 

select name from telbook where seq=1;
select name, age, address from telbook where seq=1;
select name from telbook where seq>=1 and seq <4 order by name;
select * from telbook where gender='f';
select name from telbook where seq>=1 and seq <4;

select sysdate from dual;
select systimestamp from dual;
