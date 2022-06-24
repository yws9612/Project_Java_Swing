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

INSERT INTO MEMBER VALUES(99999,'admin','admin55','관리자','admin@gmail.com','Y');
INSERT INTO MEMBER VALUES(10000,'wlxo','wlxo1','유지태','wlxo1@gmail.com','N');
INSERT INTO MEMBER VALUES(10001,'dmsdn','dmsdn1','차은우','dmsdn1@gmail.com','N');
INSERT INTO MEMBER VALUES(10002,'xodus','xodus1','김태연','xodus1@gmail.com','N');
INSERT INTO MEMBER VALUES(10003,'dnjsdud','dnjsdud1','장원영','dnjsdud1@gmail.com','N');
INSERT INTO MEMBER VALUES(10004,'wldms','wldms1','이지은','wldms1@gmail.com','N');
INSERT INTO MEMBER VALUES(10005,'ehddnjs','ehddnjs1','강동원','ehddnjs1@gmail.com','N');
INSERT INTO MEMBER VALUES(10006,'bin','bin1','원빈','bin1@gmail.com','N');
INSERT INTO MEMBER VALUES(10007,'dusdns','dusdns1','서연운','dusdns1@gmail.com','N');
INSERT INTO MEMBER VALUES(10008,'dlsrnr','dlsrnr1','서인국','dlsrnr1@gmail.com','N');
INSERT INTO MEMBER VALUES(10009,'xogml','xogml1','김태희','xogml1@gmail.com','N');
INSERT INTO MEMBER VALUES(10010,'dPtmf','dPtmf1','한예슬','dPtmf1@gmail.com','N');

SELECT * FROM MEMBER;




