--Ʈ����, ���ν���, ������ �� ��ɾ�� ���� ���� �������� �귣ġ�� �÷��ֽø� �� �� �����ϴ�! 
 
create or replace trigger ch_score
after 
insert on score --score ���̺� ������ ���Ե�����
begin
    if (member.m_no = score.m_no) --����� ȸ����ȣ�� ���ھ��� ȸ����ȣ�� ��ġ�� ��
    then update score --score ���̺��� ������
    set score.score = (select max(score.score) from score where member.m_no = score.m_no);  --�� ���� ������ ������Ʈ
    end if;
end ch_score;
/