 --트리거, 프로시져, 시퀀스 등 명령어는 보기 좋게 메인쿼리 브랜치에 올려주시면 될 것 같습니다! 
 
create or replace trigger ch_score
after 
insert on score --score 테이블에 점수가 삽입됐을때
begin
    update score --score 테이블의 점수를
    set scores = max(scores)--최고점수로 갱신
    where member.m_no = score.m_no;--where 절에서 본인임을 확인하는 식이 와야됨.
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
    values(v_m_no, v_id, v_pw, v_name, v_email, v_admin);--execute시 v_admin을 0으로 세팅하는 코드 필요
end reg_pr;
/