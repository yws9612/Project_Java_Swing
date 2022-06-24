create table member(
M_NO NUMBER(5),
ID VARCHAR2(20) 
constraint u_id unique,
PW VARCHAR2(50) not null,
NAME VARCHAR2(30) not null,
EMAIL VARCHAR2(50) 
constraint u_email unique,
ADMIN CHAR(1),
constraint PK_M_NO PRIMARY KEY(M_NO));

INSERT INTO MEMBER VALUES(99999,'admin','admin55','°ü¸®ÀÚ','admin@gmail.com','Y');
SELECT * FROM MEMBER;






