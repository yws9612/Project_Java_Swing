--트리거, 프로시져, 시퀀스 등 명령어는 보기 좋게 메인쿼리 브랜치에 올려주시면 될 것 같습니다! 
 
create or replace trigger ch_score
after 
insert on score --score 테이블에 점수가 삽입됐을때
begin
    if (member.m_no = score.m_no) --멤버의 회원번호와 스코어의 회원번호가 일치할 때
    then update score --score 테이블의 점수를
    set score.score = (select max(score.score) from score where member.m_no = score.m_no);  --더 높은 점수로 업데이트
    end if;
end ch_score;
/