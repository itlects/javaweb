use jspbookdb;

drop table member;

CREATE TABLE IF NOT EXISTS member(
   id VARCHAR(20) NOT NULL,
   passwd  VARCHAR(20),
   name VARCHAR(30),    
   PRIMARY KEY (id)
);
INSERT INTO member VALUES('1', '1234', '홍길순');
INSERT INTO member VALUES('2', '1235', '홍길동');
INSERT INTO member VALUES('3', 'pass', '홍길서');

select * from member;
