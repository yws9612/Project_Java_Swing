--트리거, 프로시져, 시퀀스 등 명령어는 보기 좋게 메인쿼리 브랜치에 올려주시면 될 것 같습니다! 
 
create or replace trigger ch_score
after 
insert on score --score 테이블에 점수가 삽입됐을때
begin
    update score --score 테이블의 점수를
    set score.score = (select max(score.score) from score where score.m_no);  --더 높은 점수로 업데이트/하려면 스코어 테이블이 하나 더있어야되나?
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