 --Ʈ����, ���ν���, ������ �� ��ɾ�� ���� ���� �������� �귣ġ�� �÷��ֽø� �� �� �����ϴ�! 
 
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


--���� ������ score ���̺� ���� ����
create or replace procedure insert_score
(v_m_no in score.m_no%type,
v_score in score.score%type)
is
begin
    insert into score values(v_m_no,v_score,sysdate);
end;
/








