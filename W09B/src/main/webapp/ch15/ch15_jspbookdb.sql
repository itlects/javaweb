create database JSPBookDB;

USE JSPBookDB;

CREATE TABLE IF NOT EXISTS member(
   id int NOT NULL AUTO_INCREMENT,
   passwd  VARCHAR(20),
   name VARCHAR(30),    
   PRIMARY KEY (id)
);

desc member;


INSERT INTO MEMBER (id, passwd, name) VALUES ('admin', '1234', '관리자');
INSERT INTO MEMBER (id, passwd, name) VALUES ('honggd', 'hong1234', '홍길동');


SELECT * fROM MEMBER;
SELECT * fROM MEMBER WHERE id='admin';

DELETE FROM MEMBER WHERE id='admin';
DELETE FROM MEMBER;

UPDATE MEMBER SET name='홍길서' WHERE id='admin';