 --트리거, 프로시져, 시퀀스 등 명령어는 보기 좋게 메인쿼리 브랜치에 올려주시면 될 것 같습니다! 

--랭킹 테이블 ... 확인 필요
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

--회원가입시 MEMBER 테이블에 데이터 추가
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
--테스트용 회원 추가(회원번호 10014)
EXECUTE REG_PR('alssl','alssl1','민니','alssl1@gmail.com');

--게임 끝나고 score 테이블에 점수 저장
create or replace procedure insert_score
(v_m_no in score.m_no%type,
v_score in score.score%type)
is
begin
    insert into score values(v_m_no,v_score,sysdate);
end;
/
--테스트용 점수 저장
execute insert_score(10014,100);

--MEMBER 테이블에 insert 되면 MANAGER 테이블에도 insert 되는 트리거
create or replace trigger tg_in_manager
after 
insert on MEMBER --member 테이블에 회원 추가될때
for each row
begin
    insert into MANAGER values (:new.m_no,sysdate,sysdate);
end tg_in_manager;
/
--테스트용 회원 추가 -- 확인 완료
EXECUTE REG_PR('tpdms','tpdms1','윤세은','tpdms1@gmail.com');
select * from manager;

--SCORE 테이블에 insert 되면 MANAGER 테이블에 LASTDATE 수정 되는 트리거
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
--테스트용 스코어 추가
execute insert_score(10000,200);
select * from manager; --확인완료

--함수 만들기 id_check / email_check 반환값 true / false로 나와야 함
create or replace function id_check
(v_m_no in member.m_no%type)
return varchar2
is
    cnt number;
begin  
    select count(*) into cnt from member where m_no = v_m_no;
    if cnt = 0 then
        return 'false'; --아이디 사용가능
    else return 'true'; --아이디 이미 사용중
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
        return 'false'; --이메일 사용가능
    else return 'true'; --이메일 이미 사용중
    end if;
end email_check;
/





