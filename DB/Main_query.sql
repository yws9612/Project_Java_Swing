--Ʈ����, ���ν���, ������ �� ��ɾ�� ���� ���� �������� �귣ġ�� �÷��ֽø� �� �� �����ϴ�! 
 
create or replace trigger ch_score
after 
insert on score --score ���̺� ������ ���Ե�����
begin
    update score --score ���̺��� ������
    set score.score = (select max(score.score) from score where score.m_no);  --�� ���� ������ ������Ʈ/�Ϸ��� ���ھ� ���̺��� �ϳ� ���־�ߵǳ�?
end ch_score;
/

create or replace procedure reg_pr
(
    v_m_no in member.m_no % type,
    v_id in member.id % type,
    v_pw in member.pw % type,
    v_name in member.name % type,
    v_email in member.email % type
)
is
begin
    insert into member (m_no, id, pw, name, email, admin)
    values(v_m_no, v_id, v_pw, v_name, v_email, null);
end reg_pr;
/