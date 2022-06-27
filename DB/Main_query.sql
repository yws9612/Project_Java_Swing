 --트리거, 프로시져, 시퀀스 등 명령어는 보기 좋게 메인쿼리 브랜치에 올려주시면 될 것 같습니다! 
 
create or replace trigger ch_score
after 
insert on score --score 테이블에 점수가 삽입됐을때
for each row
begin
    if  :old.scores < :new.scores then
        update score --score 테이블의 점수를
        set scores = :new.scores--최고점수로 갱신
        where m_no = (select m_no from member); --where 절에서 본인임을 확인하는 식이 와야됨.
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


--게임 끝나고 score 테이블에 점수 저장
create or replace procedure insert_score
(v_m_no in score.m_no%type,
v_score in score.score%type)
is
begin
    insert into score values(v_m_no,v_score,sysdate);
end;
/








