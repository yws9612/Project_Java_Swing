 --Ʈ����, ���ν���, ������ �� ��ɾ�� ���� ���� �������� �귣ġ�� �÷��ֽø� �� �� �����ϴ�! 

--��ŷ ���̺� ... Ȯ�� �ʿ�
create or replace trigger ch_score
after 
insert on score --score ���̺� ������ ���Ե�����
for each row
begin
    if  :old.scores < :new.scores then
        update score --score ���̺��� ������
        set scores = :new.scores--�ְ������� ����
        where m_no = (select m_no from member); --where ������ �������� Ȯ���ϴ� ���� �;ߵ�.
    end if;
end ch_score;
/

--ȸ�����Խ� MEMBER ���̺� ������ �߰�
create or replace procedure reg_pr
(
    v_id in member.id % type,
    v_pw in member.pw % type,
    v_name in member.name % type,
    v_email in member.email % type
)
is
begin
    insert into member (m_no, id, pw, name, email)
    values(MEM_SQ.nextval, v_id, v_pw, v_name, v_email);
end reg_pr;
/
--�׽�Ʈ�� ȸ�� �߰�(ȸ����ȣ 10014)
EXECUTE REG_PR('alssl','alssl1','�δ�','alssl1@gmail.com');

--���� ������ score ���̺� ���� ����
create or replace procedure insert_score
(v_m_no in score.m_no%type,
v_score in score.score%type)
is
begin
    insert into score values(v_m_no,v_score,sysdate);
end;
/
--�׽�Ʈ�� ���� ����
execute insert_score(10014,100);

--MEMBER ���̺� insert �Ǹ� MANAGER ���̺��� insert �Ǵ� Ʈ����
create or replace trigger tg_in_manager
after 
insert on MEMBER --member ���̺� ȸ�� �߰��ɶ�
for each row
begin
    insert into MANAGER values (:new.m_no,sysdate,sysdate);
end tg_in_manager;
/
--�׽�Ʈ�� ȸ�� �߰� -- Ȯ�� �Ϸ�
EXECUTE REG_PR('tpdms','tpdms1','������','tpdms1@gmail.com');
select * from manager;

--SCORE ���̺� insert �Ǹ� MANAGER ���̺� LASTDATE ���� �Ǵ� Ʈ����
create or replace trigger tg_lastdate
after
insert on SCORE
for each row
declare
    v_date date;
begin
    v_date := :new.playdate;
    update MANAGER set lastdate = v_date where m_no = :new.m_no;
end tg_lastdate;
/
--�׽�Ʈ�� ���ھ� �߰�
execute insert_score(10000,200);
select * from manager; --Ȯ�οϷ�

--�Լ� ����� id_check / email_check ��ȯ�� true / false�� ���;� ��
create or replace function id_check
(v_m_no in member.m_no%type)
return varchar2
is
    cnt number;
begin  
    select count(*) into cnt from member where m_no = v_m_no;
    if cnt = 0 then
        return 'false'; --���̵� ��밡��
    else return 'true'; --���̵� �̹� �����
    end if;
end id_check;
/

create or replace function email_check
(v_email in member.email%type)
return varchar2
is
    cnt number;
begin  
    select count(*) into cnt from member where email = v_email;
    if cnt = 0 then
        return 'false'; --�̸��� ��밡��
    else return 'true'; --�̸��� �̹� �����
    end if;
end email_check;
/





