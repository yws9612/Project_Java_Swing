 --Ʈ����, ���ν���, ������ �� ��ɾ�� ���� ���� �������� �귣ġ�� �÷��ֽø� �� �� �����ϴ�! 
 
create or replace trigger ch_score
after 
insert on score --score ���̺� ������ ���Ե�����
begin
    update score --score ���̺��� ������
    set scores = max(scores)--�ְ������� ����
    where member.m_no = score.m_no;--where ������ �������� Ȯ���ϴ� ���� �;ߵ�.
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