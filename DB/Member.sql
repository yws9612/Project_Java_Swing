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

--MEMBER 시퀀스 생성
CREATE SEQUENCE MEM_SQ
INCREMENT BY 1
START WITH 10000
MAXVALUE 88888
MINVALUE 10000
NOCYCLE
NOCACHE;

--관리자 ID 삽입
INSERT INTO MEMBER VALUES(99999,'admin','admin55','관리자','admin@gmail.com','Y');

--회원 ID 삽입
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'wlxo','wlxo1','유지태','wlxo1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dmsdn','dmsdn1','차은우','dmsdn1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xodus','xodus1','김태연','xodus1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dnjsdud','dnjsdud1','장원영','dnjsdud1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'wldms','wldms1','이지은','wldms1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'ehddnjs','ehddnjs1','강동원','ehddnjs1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'bin','bin1','원빈','bin1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dusdns','dusdns1','서연운','dusdns1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dlsrnr','dlsrnr1','서인국','dlsrnr1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xogml','xogml1','김태희','xogml1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dPtmf','dPtmf1','한예슬','dPtmf1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xogud','xogud1','김태형','xogud1@gmail.com','N');


