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
    v_m_no in member.m_no % type,
    v_id in member.id % type,
    v_pw in member.pw % type,
    v_name in member.name % type,
    v_email in member.email % type,
    v_admin in member.admin % type
)
is
begin
    insert into member (m_no, id, pw, name, email, admin)
    values(v_m_no, v_id, v_pw, v_name, v_email, v_admin);--execute�� v_admin�� 0���� �����ϴ� �ڵ� �ʿ�
end reg_pr;
/