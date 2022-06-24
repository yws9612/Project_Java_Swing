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

INSERT INTO MEMBER VALUES(99999,'admin','admin55','������','admin@gmail.com','Y');
INSERT INTO MEMBER VALUES(10000,'wlxo','wlxo1','������','wlxo1@gmail.com','N');
INSERT INTO MEMBER VALUES(10001,'dmsdn','dmsdn1','������','dmsdn1@gmail.com','N');
INSERT INTO MEMBER VALUES(10002,'xodus','xodus1','���¿�','xodus1@gmail.com','N');
INSERT INTO MEMBER VALUES(10003,'dnjsdud','dnjsdud1','�����','dnjsdud1@gmail.com','N');
INSERT INTO MEMBER VALUES(10004,'wldms','wldms1','������','wldms1@gmail.com','N');
INSERT INTO MEMBER VALUES(10005,'ehddnjs','ehddnjs1','������','ehddnjs1@gmail.com','N');
INSERT INTO MEMBER VALUES(10006,'bin','bin1','����','bin1@gmail.com','N');
INSERT INTO MEMBER VALUES(10007,'dusdns','dusdns1','������','dusdns1@gmail.com','N');
INSERT INTO MEMBER VALUES(10008,'dlsrnr','dlsrnr1','���α�','dlsrnr1@gmail.com','N');
INSERT INTO MEMBER VALUES(10009,'xogml','xogml1','������','xogml1@gmail.com','N');
INSERT INTO MEMBER VALUES(10010,'dPtmf','dPtmf1','�ѿ���','dPtmf1@gmail.com','N');

SELECT * FROM MEMBER;




