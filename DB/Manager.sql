create table manager(
M_NO NUMBER(5)
constraint FK_M_NO REFERENCES MEMBER(M_NO),
R_DATE DATE,
LASTDATE DATE);

desc manager;