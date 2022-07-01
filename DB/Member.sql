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

--MEMBER ������ ����
CREATE SEQUENCE MEM_SQ
INCREMENT BY 1
START WITH 10000
MAXVALUE 88888
MINVALUE 10000
NOCYCLE
NOCACHE;

--������ ID ����
INSERT INTO MEMBER VALUES(99999,'admin','admin55','������','admin@gmail.com','Y');

--ȸ�� ID ����
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'wlxo','wlxo1','������','wlxo1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dmsdn','dmsdn1','������','dmsdn1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xodus','xodus1','���¿�','xodus1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dnjsdud','dnjsdud1','�����','dnjsdud1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'wldms','wldms1','������','wldms1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'ehddnjs','ehddnjs1','������','ehddnjs1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'bin','bin1','����','bin1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dusdns','dusdns1','������','dusdns1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dlsrnr','dlsrnr1','���α�','dlsrnr1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xogml','xogml1','������','xogml1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'dPtmf','dPtmf1','�ѿ���','dPtmf1@gmail.com','N');
INSERT INTO MEMBER VALUES(MEM_SQ.NEXTVAL,'xogud','xogud1','������','xogud1@gmail.com','N');

--MEMBER ADMIN DEFAULT�� �缳�� �� �׽�Ʈ�� ȸ�� �߰�
ALTER TABLE MEMBER MODIFY ADMIN CHAR(1) DEFAULT 'N';
DESC MEMBER;
INSERT INTO MEMBER (M_NO,ID,PW,NAME,EMAIL) VALUES(MEM_SQ.NEXTVAL,'alstjr','alstjr1','��μ�','alstjr1@gmail.com');
INSERT INTO MEMBER (M_NO,ID,PW,NAME,EMAIL) VALUES(MEM_SQ.NEXTVAL,'tjgka','tjgka1','�ڼ���','tjgka1@gmail.com');
SELECT * FROM MEMBER;

